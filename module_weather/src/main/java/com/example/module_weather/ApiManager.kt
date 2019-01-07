package com.example.module_weather

import com.example.commonsdk.http.RetrofitInstance

/**
 * @author
 * @Date 2019/1/1
 * @description
 * @since 1.0.0
 */
val url = "https://www.apiopen.top/"

class ApiManager private constructor() {
    private var iWeather: WeatherService = build(url, WeatherService::class.java)

    fun getIWeather(): WeatherService {
        return iWeather
    }

    private fun <T> build(host: String, cls: Class<T>): T {
        return RetrofitInstance
            .getInstance()
            .getRetrofit(host)
            .create(cls)
    }

    companion object {
        var instance = ApiManager()
            private set

        fun reset() {
            instance = ApiManager()
        }
    }
}