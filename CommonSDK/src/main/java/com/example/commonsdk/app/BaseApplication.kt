package com.example.commonsdk.app

import android.app.Application
import android.content.Context

/**
 * @author
 * @Date 2019/1/3
 * @description
 * @since 1.0.0
 */
open class BaseApplication :Application() {

    private var appDelegate: ApplicationLifecycleDelegate? = null

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        if (appDelegate == null){
            appDelegate = AppDelegate(base)
        }
        appDelegate?.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        appDelegate?.onCreate(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        appDelegate?.onTerminate()
    }
}