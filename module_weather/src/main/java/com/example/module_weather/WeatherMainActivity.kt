package com.example.module_weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.weather_main_activity.*

class WeatherMainActivity : BaseActivity() {

    private lateinit var weatherMainViewModel: WeatherMainViewModel
    private lateinit var dataSource: DataSource

    override fun getLayout(): Int {
        return R.layout.weather_main_activity
    }

    override fun initData() {
        weatherMainViewModel = getViewModel().apply {

        }

    }


    fun getViewModel():WeatherMainViewModel = obtainViewModel(WeatherMainViewModel::class.java,dataSource)
}
