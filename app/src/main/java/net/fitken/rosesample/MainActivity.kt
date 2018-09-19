package net.fitken.rosesample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.fitken.rose.Rose

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Rose.debug("this is the very first log")
        Rose.error("this is the very first log")
    }
}
