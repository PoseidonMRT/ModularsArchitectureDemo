package com.example.module_article.app

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonsdk.app.ApplicationLifecycleDelegate
import com.example.module_article.BuildConfig
import com.squareup.leakcanary.LeakCanary

/**
 * @author
 * @Date 2019/1/8
 * @description
 * @since 1.0.0
 */
class AppLifecycleDelegate:ApplicationLifecycleDelegate{

    override fun attachBaseContext(base: Context) {

    }

    override fun onCreate(application: Application) {
        Log.e("TZB","module article application init")
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(application)
        initLeakCanary(application)
    }

    override fun onTerminate() {

    }

    private fun initLeakCanary(application: Application){
        if (LeakCanary.isInAnalyzerProcess(application)){
            return
        }
        LeakCanary.install(application)
    }
}