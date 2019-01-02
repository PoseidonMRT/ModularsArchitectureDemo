package com.example.module_weather

import com.example.module_weather.entity.ResponseMsg
import com.example.module_weather.entity.weather.ResponseWeatherData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author
 * @Date 2019/1/1
 * @description
 * @since 1.0.0
 */
class WeatherDataSource() : DataSource {
    fun queryWeather(cityname: String): Observable<ResponseMsg<ResponseWeatherData>> {
        return ApiManager.instance
            .getIWeather()
            .queryWeather(cityname)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}