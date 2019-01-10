package com.example.module_article

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.commonsdk.utils.DateUtils
import com.example.commonservice.article.ResponseArticle
import com.example.commonservice.article.entity.ResponseArticleData
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author
 * @Date 2019/1/8
 * @description
 * @since 1.0.0
 */
class ArticleMainViewModel(var context: Application) : AndroidViewModel(context) {

    private var articleDataSource: ArticleDataSource

    var todayArticle: ObservableField<ResponseArticleData> = ObservableField()
    var currentDate: ObservableField<String> = ObservableField()

    init {
        articleDataSource = ArticleDataSource()
        currentDate.set(DateUtils.getCurrentDate())
    }

    fun loadTodayArticle() {
        articleDataSource.loadTodayArticle(1)
            .subscribe(object : Observer<ResponseArticle> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    Log.e("TZB", e.message)
                }

                override fun onNext(t: ResponseArticle) {
                    Log.e("TZB", "response in viewmodel:" + t.data.toString())
                    currentDate.set(t.data.date.curr)
                    todayArticle.set(t.data)
                }
            })
    }

    fun loadArticleDate(distance:Int) {
        Log.e("TZB",currentDate.get())
        var date = DateUtils.getOldDate(currentDate.get() as String,distance)
        articleDataSource.loadArticleDate(1,date)
            .subscribe(object : Observer<ResponseArticle> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    Log.e("TZB", e.message)
                }

                override fun onNext(t: ResponseArticle) {
                    Log.e("TZB", "response in viewmodel:" + t.data.toString())
                    currentDate.set(t.data.date.curr)
                    todayArticle.set(t.data)
                }
            })
    }

    fun loadArticleRandom() {
        articleDataSource.loadArticleRandom(1)
            .subscribe(object : Observer<ResponseArticle> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    Log.e("TZB", e.message)
                }

                override fun onNext(t: ResponseArticle) {
                    Log.e("TZB", "response in viewmodel:" + t.data.toString())
                    currentDate.set(t.data.date.curr)
                    todayArticle.set(t.data)
                }
            })
    }
}