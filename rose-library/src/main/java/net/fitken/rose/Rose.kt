package net.fitken.rose

import android.util.Log


object Rose {
    val TAG = Rose::class.java.simpleName
    private var isDebugEnabled: Boolean = true


    fun debugEnabled(debugEnabled: Boolean) {
        this.isDebugEnabled = debugEnabled
    }

    fun debug(msg: Any) {
        if (isDebugEnabled) {
            Log.i(TAG, StackTraceInfo.invokingMethodNameFqn)
            Log.d(TAG, msg.toString())
        }
    }

    fun error(msg: Any) {
        if (isDebugEnabled) {
            Log.i(TAG, StackTraceInfo.invokingFileNameFqn)
            Log.e(TAG, msg.toString())
        }
    }
}
