package com.example.commonservice.article

import com.example.commonservice.ResponseArticle
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @author
 * @Date 2019/1/8
 * @description
 * @since 1.0.0
 */
interface ArticleService {

    @Headers(
        "Accept: application/vnd.github.v3.full+json",
        "User-Agent: Retrofit-Sample-App"
    )
    @GET("today")
    fun loadTodayArticle(@Query("dev") dev:Int): Observable<ResponseArticle>
}