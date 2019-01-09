package com.example.module_article

import com.example.commonsdk.http.RetrofitInstance
import com.example.commonservice.article.ArticleService

/**
 * @author
 * @Date 2019/1/1
 * @description
 * @since 1.0.0
 */
val url = "http://interface.meiriyiwen.com/article/"

class ArticleApiManager private constructor() {

    private var iArticleService: ArticleService = build(url, ArticleService::class.java)

    fun getIArticle(): ArticleService {
        return iArticleService
    }

    private fun <T> build(host: String, cls: Class<T>): T {
        return RetrofitInstance
            .getInstance()
            .getRetrofit(host)
            .create(cls)
    }

    companion object {
        var instance = ArticleApiManager()
            private set

        fun reset() {
            instance = ArticleApiManager()
        }
    }
}