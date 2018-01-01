package io.github.anotherjack.autodisposedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.github.anotherjack.autodispose.AutoDispose
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_act_example.*

class ActExampleActivity : AppCompatActivity() {
    private val autoDispose: AutoDispose by lazy { AutoDispose(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_example)

        button.setOnClickListener {

            Observable.create<Int> {
                for (i in 1..100){
                    it.onNext(i)
                    Thread.sleep(1000)
                }
                it.onComplete()
            }
                    .compose(autoDispose.bind())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()
                    }
            finish()
        }
    }
}
