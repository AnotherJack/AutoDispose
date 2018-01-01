package io.github.anotherjack.autodisposedemo


import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TestFragment : Fragment() {
    private val TAG = "TestFragment"


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_test, container, false)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Observable.create<Int> {
                for (i in 1..100){
                    it.onNext(i)
                    Thread.sleep(1000)
                }
                it.onComplete()
            }
//                    .compose(autoDispose.bind())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d(TAG," --> $it")
                    }
            fragmentManager.beginTransaction()
                    .remove(this)
                    .commit()
        }

        return view
    }

}
