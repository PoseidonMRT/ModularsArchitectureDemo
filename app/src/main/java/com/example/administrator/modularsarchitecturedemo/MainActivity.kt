package com.example.administrator.modularsarchitecturedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonsdk.RouterHub
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouterHub.APP_MAIN_ACTIVITY)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        weather_iv.setOnClickListener {
            ARouter.getInstance().build(RouterHub.WEATHER_MAIN_ACTIVITY).navigation(this@MainActivity)
        }

        news_iv.setOnClickListener {
            ARouter.getInstance().build(RouterHub.NEWS_MAIN_ACTIVITY).navigation(this@MainActivity)
        }
    }
}
