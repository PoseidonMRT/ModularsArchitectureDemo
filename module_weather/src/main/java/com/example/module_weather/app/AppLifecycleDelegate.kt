package com.example.module_weather.app

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonsdk.app.ApplicationLifecycleDelegate
import com.example.module_weather.BuildConfig
import com.example.module_weather.RetrofitManager

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

        RetrofitManager.instance.init(application.applicationContext)
        if (BuildConfig.DEBUG){
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(application)
    }

    override fun onTerminate() {
        Log.e("TZB","Application onTerminate")
    }
}