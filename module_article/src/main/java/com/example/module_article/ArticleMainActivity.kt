package com.example.module_article

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonsdk.RouterHub
import com.example.commonsdk.base.BaseActivity

@Route(path = RouterHub.ARTICLE_MAIN_ACTIVITY)
class ArticleMainActivity : BaseActivity() {

    override fun getLayout(): Int = R.layout.article_activity_main

    override fun initData() {

    }

    override fun initComponent() {

    }
}
