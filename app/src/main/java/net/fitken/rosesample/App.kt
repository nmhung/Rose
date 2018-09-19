package net.fitken.rosesample

import android.app.Application
import net.fitken.rose.Rose

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Rose.debugEnabled(BuildConfig.DEBUG)
    }
}