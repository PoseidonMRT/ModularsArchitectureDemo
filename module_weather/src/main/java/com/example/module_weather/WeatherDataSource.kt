package com.example.module_weather

import com.example.commonservice.weather.ResponseWeatherMsg
import com.example.module_weather.entity.weather.ResponseWeatherData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author
 * @Date 2019/1/1
 * @description
 * @since 1.0.0
 */
class WeatherDataSource {

    fun queryWeather(cityname: String): Observable<ResponseWeatherMsg<ResponseWeatherData>> {
        return ApiManager.instance
            .getIWeather()
            .queryWeather(cityname)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}