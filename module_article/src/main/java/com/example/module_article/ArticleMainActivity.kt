package com.example.module_article

import android.text.Html
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.Observable
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonsdk.RouterHub
import com.example.commonsdk.base.BaseActivity
import com.example.commonservice.article.ResponseArticleData
import kotlinx.android.synthetic.main.article_activity_main.*

@Route(path = RouterHub.ARTICLE_MAIN_ACTIVITY)
class ArticleMainActivity : BaseActivity() {

    private lateinit var articleMainViewModel: ArticleMainViewModel

    private lateinit var drawerToggle:ActionBarDrawerToggle

    override fun getLayout(): Int = R.layout.article_activity_main

    override fun initData() {
        articleMainViewModel = ViewModelFactory.getInstance(application).create(ArticleMainViewModel::class.java)

        articleMainViewModel.apply {
            todayArticle.addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    var todayArticle:ResponseArticleData = todayArticle.get() as ResponseArticleData
                    article_author.text = todayArticle.author
                    article_content.text = Html.fromHtml(todayArticle.content)
                    article_title.text = todayArticle.title
                }
            })
        }

        articleMainViewModel.loadTodayArticle()

        drawerToggle = ActionBarDrawerToggle(this,article_main_drawer_layout,R.string.article_drawer_open,R.string.article_drawer_close)
        article_main_drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        article_open_left_drawer_iv.setOnClickListener {
            if (!article_main_drawer_layout.isDrawerOpen(article_main_drawer_left_layout)){
                article_main_drawer_layout.openDrawer(article_main_drawer_left_layout)
            }
        }

        article_open_right_drawer_iv.setOnClickListener {
            if (!article_main_drawer_layout.isDrawerOpen(article_main_drawer_right_layout)){
                article_main_drawer_layout.openDrawer(article_main_drawer_right_layout)
            }
        }
    }

    override fun initComponent() {

    }
}
