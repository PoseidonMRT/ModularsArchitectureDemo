package com.example.commonsdk.app

import android.app.Application
import android.content.Context

/**
 * @author
 * @Date 2019/1/3
 * @description
 * @since 1.0.0
 */
class AppDelegate (context: Context): ApplicationLifecycleDelegate {

    private var mAppLifecycleList:ArrayList<ApplicationLifecycleDelegate> = ApplicationManifestParser(
        context
    ).parse()

    override fun attachBaseContext(base: Context) {
        for (appLifecycleDelegate in mAppLifecycleList){
            appLifecycleDelegate.attachBaseContext(base)
        }
    }

    override fun onCreate(application: Application) {
        for (appLifecycleDelegate in mAppLifecycleList){
            appLifecycleDelegate.onCreate(application)
        }
    }

    override fun onTerminate() {
        for (appLifecycleDelegate in mAppLifecycleList){
            appLifecycleDelegate.onTerminate()
        }
    }
}