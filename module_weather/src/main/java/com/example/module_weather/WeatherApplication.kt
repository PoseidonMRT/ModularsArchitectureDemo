package com.example.module_weather

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonsdk.AppDelegate

/**
 * @author
 * @Date 2019/1/3
 * @description
 * @since 1.0.0
 */
class WeatherApplication:AppDelegate {
    override fun onCreate(application: Application) {
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(application)
    }
}