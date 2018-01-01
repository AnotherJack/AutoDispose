package io.github.anotherjack.autodisposedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class FragExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_example)

        val testFragment = TestFragment()
        fragmentManager.beginTransaction()
                .add(R.id.frag_container,testFragment)
                .commit()
    }
}
