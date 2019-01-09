package com.example.commonsdk.http

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author
 * @Date 2019/1/7
 * @description
 * @since 1.0.0
 */
class RetrofitInstance {

    private val CONNECT_TIMEOUT = 30L
    private val READ_TIMEOUT = 30L
    private val WRITE_TIMEOUT = 30L

    private lateinit var okHttpClient: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        builder.addInterceptor(LoggingInterceptor())
        okHttpClient = builder.build()
    }

    fun getRetrofit(host: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(host)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: RetrofitInstance? = null

        fun getInstance() =
            INSTANCE ?: synchronized(RetrofitInstance::class.java) {
                INSTANCE ?: RetrofitInstance()
                    .also { INSTANCE = it }
            }
    }
}