package com.example.module_article

import android.graphics.Color
import android.text.Html
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.Observable
import androidx.drawerlayout.widget.DrawerLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonsdk.RouterHub
import com.example.commonsdk.base.BaseActivity
import com.example.commonsdk.utils.DateUtils
import com.example.commonservice.article.entity.ResponseArticleData
import kotlinx.android.synthetic.main.article_activity_main.*

@Route(path = RouterHub.ARTICLE_MAIN_ACTIVITY)
class ArticleMainActivity : BaseActivity() {

    private lateinit var articleMainViewModel: ArticleMainViewModel

    private lateinit var drawerToggle:ActionBarDrawerToggle

    override fun getLayout(): Int = R.layout.article_activity_main

    override fun initComponent() {}

    override fun initViewModel() {
        articleMainViewModel = ViewModelFactory.getInstance(application).create(ArticleMainViewModel::class.java)

        articleMainViewModel.apply {
            todayArticle.addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    var todayArticle: ResponseArticleData = todayArticle.get() as ResponseArticleData
                    article_author.text = todayArticle.author
                    article_content.text = Html.fromHtml(todayArticle.content)
                    article_title.text = todayArticle.title
                }
            })

            currentDate.addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    var date = currentDate.get() as String
                    if (date == DateUtils.getCurrentDate()){
                        article_main_next.visibility = View.GONE
                    }else{
                        article_main_next.visibility = View.VISIBLE
                    }
                }
            })
        }
    }

    override fun initViewState() {
        initDrawerLayout()

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

        article_main_next.setOnClickListener {
            articleMainViewModel.loadArticleDate(1)
        }

        article_main_prev.setOnClickListener {
            articleMainViewModel.loadArticleDate(-1)
        }

        article_main_random.setOnClickListener {
            articleMainViewModel.loadArticleRandom()
        }

        article_main_today.setOnClickListener {
            articleMainViewModel.loadTodayArticle()
        }
    }

    private fun initDrawerLayout(){
        drawerToggle = ActionBarDrawerToggle(this,article_main_drawer_layout,R.string.article_drawer_open,R.string.article_drawer_close)
        article_main_drawer_layout.addDrawerListener(drawerToggle)
        article_main_drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        article_main_drawer_layout.setScrimColor(Color.TRANSPARENT)
        drawerToggle.syncState()
    }

    override fun initData() {
    }

    override fun onResume() {
        super.onResume()
        articleMainViewModel.loadTodayArticle()
    }
}
