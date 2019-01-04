package com.example.commonsdk.app

import android.app.Application
import android.content.Context

/**
 * @author
 * @Date 2019/1/3
 * @description
 * @since 1.0.0
 */
interface ApplicationLifecycleDelegate {
    fun attachBaseContext(base: Context)

    fun onCreate(application: Application)

    fun onTerminate()
}