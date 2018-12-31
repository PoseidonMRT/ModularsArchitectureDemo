package com.example.module_weather.entity.weather

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
data class ResponseYesterdayWeather(
    var date: String,
    var high: String,
    var fx: String,
    var low: String,
    var fl: String,
    var type: String
)