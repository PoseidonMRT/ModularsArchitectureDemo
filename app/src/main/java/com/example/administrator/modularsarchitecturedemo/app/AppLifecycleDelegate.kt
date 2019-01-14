package com.example.administrator.modularsarchitecturedemo.app

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.administrator.modularsarchitecturedemo.BuildConfig
import com.example.commonsdk.app.ApplicationLifecycleDelegate
import com.squareup.leakcanary.LeakCanary

/**
 * @author
 * @Date 2019/1/4
 * @description
 * @since 1.0.0
 */
class AppLifecycleDelegate: ApplicationLifecycleDelegate {

    override fun attachBaseContext(base: Context) {

    }

    override fun onCreate(application: Application) {
        if (BuildConfig.DEBUG){
            ARouter.openDebug()
            ARouter.openLog()
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