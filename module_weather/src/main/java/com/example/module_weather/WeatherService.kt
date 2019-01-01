package com.example.module_weather

import com.example.module_weather.entity.ResponseMsg
import com.example.module_weather.entity.weather.ResponseWeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * @author
 * @Date 2019/1/1
 * @description
 * @since 1.0.0
 */
interface WeatherService {

    @GET("weatherApi")
    fun queryWeather(@Query("city") cityname: String):Observable<ResponseMsg<ResponseWeatherData>>
}