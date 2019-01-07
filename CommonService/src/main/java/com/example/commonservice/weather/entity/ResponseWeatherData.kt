package com.example.module_weather.entity.weather

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
data class ResponseWeatherData(
    var yesterday: ResponseYesterdayWeather,
    var city: String,
    var aqi: String,
    var forecast: List<ResponseWeatherForcast>,
    var ganmao: String,
    var wendu: String
)