package com.example.commonsdk

/**
 * @author
 * @Date 2019/1/3
 * @description
 * @since 1.0.0
 */
interface RouterHub {
    companion object {
        /**
         * 组名
         */
        const val APP = "/app"//宿主 App 组件
        const val WEATHER = "/weather"//天气组件


        /**
         * 宿主 App 分组
         */
        const val APP_MAIN_ACTIVITY = "$APP/MainActivity"


        /**
         * 天气模块分组
         */
        const val WEATHER_MAIN_ACTIVITY = "$WEATHER/WeatherMainActivity"
    }
}
