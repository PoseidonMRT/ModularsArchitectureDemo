package com.example.commonservice

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
data class ResponseMsg<T>(
    var code: Int,
    var msg: String,
    var data: T
)