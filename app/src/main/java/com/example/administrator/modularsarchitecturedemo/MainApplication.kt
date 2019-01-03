package com.example.administrator.modularsarchitecturedemo

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author
 * @Date 2019/1/3
 * @description
 * @since 1.0.0
 */
class MainApplication:Application() {
//    var weatherApplication:WeatherApplication = WeatherApplication()
    override fun onCreate() {
        super.onCreate()
//        weatherApplication.onCreate(this)
        if (BuildConfig.DEBUG){
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }
}