package io.github.anotherjack.autodispose;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by jack on 2017/12/31.
 */

public class AutoDisposeFragment extends Fragment {
    private static final String TAG = "AutoDisposeFragment";
    private CompositeDisposable mDisposables = new CompositeDisposable();

    public AutoDisposeFragment() {
    }

    public <T> ObservableTransformer<T,T> bind(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mDisposables.add(disposable);
                    }
                });
            }
        };
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG," --> onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG," --> onCreate");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG," --> onViewCreated");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG," --> onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG," --> onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG," --> onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG," --> onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG," --> onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG," --> onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG," --> onDestroy");
        mDisposables.clear();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG," --> onDetach");
    }
}
