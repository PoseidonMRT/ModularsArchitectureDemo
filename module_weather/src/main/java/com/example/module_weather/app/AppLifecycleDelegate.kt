package com.example.module_weather.app

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonsdk.app.ApplicationLifecycleDelegate
import com.example.module_weather.BuildConfig
import com.squareup.leakcanary.LeakCanary

/**
 * @author
 * @Date 2019/1/4
 * @description
 * @since 1.0.0
 */
class AppLifecycleDelegate: ApplicationLifecycleDelegate {
    override fun attachBaseContext(base: Context) {
        Log.e("TZB","Application init")
    }

    override fun onCreate(application: Application) {
        Log.e("TZB","Application onCreate")

        if (BuildConfig.DEBUG){
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(application)

        initLeakCanary(application)
    }

    override fun onTerminate() {
        Log.e("TZB","Application onTerminate")
    }

    private fun initLeakCanary(application: Application){
        if (LeakCanary.isInAnalyzerProcess(application)){
            return
        }
        LeakCanary.install(application)
    }
}