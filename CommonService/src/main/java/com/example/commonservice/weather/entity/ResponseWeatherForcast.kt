package com.example.module_weather.entity.weather

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
data class ResponseWeatherForcast(
    var date: String,
    var high: String,
    var fengli: String,
    var low: String,
    var fengxiang: String,
    var type: String
)