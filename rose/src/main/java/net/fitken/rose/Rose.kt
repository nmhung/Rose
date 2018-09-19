package net.fitken.rose

import android.util.Log


object Rose {
    val TAG = Rose::class.java.simpleName

    fun debug(msg: Any) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, StackTraceInfo.invokingMethodNameFqn)
            Log.d(TAG, msg.toString())
        }
    }

    fun error(msg: Any) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, StackTraceInfo.invokingFileNameFqn)
            Log.e(TAG, msg.toString())
        }
    }
}
