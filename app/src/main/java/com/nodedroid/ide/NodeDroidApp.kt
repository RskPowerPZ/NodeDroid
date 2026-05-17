package com.nodedroid.ide

import android.app.Application
import com.nodedroid.ide.util.CrashHandler

class NodeDroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        CrashHandler(this)
    }
}
