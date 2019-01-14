package com.example.administrator.modularsarchitecturedemo.app

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.administrator.modularsarchitecturedemo.BuildConfig
import com.example.commonsdk.app.ApplicationLifecycleDelegate

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
    }

    override fun onTerminate() {

    }
}