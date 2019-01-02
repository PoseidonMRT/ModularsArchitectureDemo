package com.example.module_weather

import android.content.Context
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author
 * @Date 2019/1/1
 * @description
 * @since 1.0.0
 */
class RetrofitManager private constructor() {
    var defaultClient: OkHttpClient? = null
        private set

    private val okHttpClientBuilder: OkHttpClient.Builder
        get() {
            val builder = OkHttpClient.Builder()
            builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            return builder
        }

    fun init(context: Context, okHttpClient: OkHttpClient) {
        this.defaultClient = okHttpClient
    }

    fun init(context: Context) {
        this.defaultClient = okHttpClientBuilder.build()
    }

    companion object {
        val instance = RetrofitManager()

        private const val CONNECT_TIMEOUT = 30L
        private const val READ_TIMEOUT = 30L
        private const val WRITE_TIMEOUT = 30L
    }
}
