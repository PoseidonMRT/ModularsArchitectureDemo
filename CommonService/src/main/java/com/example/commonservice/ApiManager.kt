package com.example.commonservice

import com.example.commonsdk.http.RetrofitInstance
import com.example.commonservice.article.ArticleService
import com.example.commonservice.weather.WeatherService

/**
 * @author
 * @Date 2019/1/1
 * @description
 * @since 1.0.0
 */
val article_url = "http://interface.meiriyiwen.com/article/"
val weather_url = "https://www.apiopen.top/"

class ApiManager private constructor() {

    private var iArticleService: ArticleService = build(article_url, ArticleService::class.java)
    private var iWeather: WeatherService = build(weather_url, WeatherService::class.java)

    fun getIArticle(): ArticleService {
        return iArticleService
    }

    fun getIWeather(): WeatherService {
        return iWeather
    }

    private fun <T> build(host: String, cls: Class<T>): T {
        return RetrofitInstance
            .getInstance()
            .getRetrofit(host)
            .create(cls)
    }

    companion object {
        var instance = ApiManager()
            private set

        fun reset() {
            instance = ApiManager()
        }
    }
}