package com.example.commonservice.weather

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
data class ResponseWeatherMsg<T>(
    var code: Int,
    var msg: String,
    var data: T
)