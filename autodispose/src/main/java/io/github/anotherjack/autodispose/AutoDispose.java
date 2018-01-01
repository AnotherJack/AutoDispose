package io.github.anotherjack.autodispose;

import android.app.Activity;
import android.app.FragmentManager;
import io.reactivex.ObservableTransformer;

/**
 * Created by jack on 2017/12/31.
 */

public class AutoDispose {
    private static final String TAG = "AutoDispose";
    private AutoDisposeFragment mAutoDisposeFragment;

    public AutoDispose(Activity activity) {
        mAutoDisposeFragment = getAutoDisposeFragment(activity);
    }

    private AutoDisposeFragment getAutoDisposeFragment(Activity activity) {
        AutoDisposeFragment AutoDisposeFragment = findAutoDisposeFragment(activity);
        if (AutoDisposeFragment == null) {
            AutoDisposeFragment = new AutoDisposeFragment();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(AutoDisposeFragment, TAG)
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return AutoDisposeFragment;
    }

    private AutoDisposeFragment findAutoDisposeFragment(Activity activity) {
        return (AutoDisposeFragment) activity.getFragmentManager().findFragmentByTag(TAG);
    }

    //TODO 增加对fragment的支持与兼容

    public <T> ObservableTransformer<T,T> bind(){
        return mAutoDisposeFragment.bind();
    }
}
