package com.example.module_article

import android.util.Log
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
        return ArticleApiManager.instance
            .getIArticle()
            .loadTodayArticle(dev)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}