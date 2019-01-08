package com.example.module_news

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonsdk.RouterHub
import com.example.commonsdk.base.BaseActivity

@Route(path = RouterHub.NEWS_MAIN_ACTIVITY)
class NewsMainActivity : BaseActivity() {

    override fun getLayout(): Int = R.layout.news_activity_main

    override fun initData() {

    }

    override fun initComponent() {

    }
}
