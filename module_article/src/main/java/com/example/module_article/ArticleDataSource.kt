package com.example.module_article

import android.util.Log
import com.example.commonservice.ApiManager
import com.example.commonservice.article.ResponseArticle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author
 * @Date 2019/1/8
 * @description
 * @since 1.0.0
 */
class ArticleDataSource {

    fun loadTodayArticle(dev:Int): Observable<ResponseArticle> {
        Log.e("TZB","load article in datasource")
        return ApiManager.instance
            .getIArticle()
            .loadTodayArticle(dev)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun loadArticleDate(dev:Int,date:String):Observable<ResponseArticle>{
        return ApiManager.instance
            .getIArticle()
            .loadArticleDate(dev,date)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun loadArticleRandom(dev:Int):Observable<ResponseArticle>{
        return ApiManager.instance
            .getIArticle()
            .loadArticleRandom(dev)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}