package com.example.module_article

import android.util.Log
import androidx.databinding.Observable
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonsdk.RouterHub
import com.example.commonsdk.base.BaseActivity
import com.example.commonservice.article.ResponseArticleData

@Route(path = RouterHub.ARTICLE_MAIN_ACTIVITY)
class ArticleMainActivity : BaseActivity() {

    private lateinit var articleMainViewModel: ArticleMainViewModel

    override fun getLayout(): Int = R.layout.article_activity_main

    override fun initData() {
        articleMainViewModel = ViewModelFactory.getInstance(application).create(ArticleMainViewModel::class.java)

        articleMainViewModel.apply {
            todayArticle.addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    var todayArticle:ResponseArticleData = todayArticle.get() as ResponseArticleData
                    Log.e("TZB",todayArticle.toString())
                }
            })
        }

        articleMainViewModel.loadTodayArticle()
    }

    override fun initComponent() {

    }
}
