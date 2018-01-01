package io.github.anotherjack.autodisposedemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import io.github.anotherjack.autodispose.AutoDispose
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG," --> onCreate")

        btn_activity.setOnClickListener {
            val i = Intent(this,ActExampleActivity::class.java)
            startActivity(i)
        }

        btn_fragment.setOnClickListener {
            val i = Intent(this,FragExampleActivity::class.java)
            startActivity(i)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG," --> onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG," --> onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG," --> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG," --> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG," --> onDestroy")
    }
}
