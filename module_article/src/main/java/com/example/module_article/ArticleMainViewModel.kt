package com.example.module_article

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.commonservice.ResponseArticle
import com.example.commonservice.article.ResponseArticleData
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author
 * @Date 2019/1/8
 * @description
 * @since 1.0.0
 */
class ArticleMainViewModel(var context: Application):AndroidViewModel(context) {

    private var articleDataSource:ArticleDataSource

    var todayArticle: ObservableField<ResponseArticleData> = ObservableField()

    init {
        articleDataSource = ArticleDataSource()
    }


    fun loadTodayArticle(){
        Log.e("TZB","load Article in viewmodel")
        articleDataSource.loadTodayArticle(1)
            .subscribe(object : Observer<ResponseArticle> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                Log.e("TZB",e.message)
            }

            override fun onNext(t: ResponseArticle) {
                Log.e("TZB","response in viewmodel:"+t.data.toString())
                todayArticle.set(t.data)
            }
        })
    }
}