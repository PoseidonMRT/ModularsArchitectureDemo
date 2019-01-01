package com.example.module_weather

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_weather.entity.weather.ResponseWeatherForcast
import kotlinx.android.synthetic.main.weather_main_activity.*

class WeatherMainActivity : BaseActivity() {

    private lateinit var weatherMainViewModel: WeatherMainViewModel
    private var dataSource: LocalDataSource = LocalDataSource()
    private lateinit var weatherForecastRecyclerAdapter: WeatherForecastRecyclerAdapter

    override fun getLayout(): Int {
        return R.layout.weather_main_activity
    }

    override fun initData() {
        weatherMainViewModel = getViewModel().apply {

        }

        var layoutManager = LinearLayoutManager(this)
        weatherForecastRecyclerAdapter = WeatherForecastRecyclerAdapter(this,generateWeatherInfo())
        weather_forecast_list.adapter = weatherForecastRecyclerAdapter
        weather_forecast_list.layoutManager = layoutManager
    }

    fun generateWeatherInfo():ArrayList<ResponseWeatherForcast> {
        var list = arrayListOf<ResponseWeatherForcast>()
        for (i in 1..10){
            var responseWeatherForcast:ResponseWeatherForcast = ResponseWeatherForcast("星期三","20","四级","15","西南","多云")
            if (i % 3 == 0){
                responseWeatherForcast= ResponseWeatherForcast("星期三","20","四级","15","西南","多云")
            }
            if (i%3 == 1){
                responseWeatherForcast= ResponseWeatherForcast("星期三","10","四级","5","西北","晴")
            }
            if (i%3 == 2){
                responseWeatherForcast= ResponseWeatherForcast("星期三","5","四级","-2","西北","阴")
            }
            list.add(responseWeatherForcast)
        }
        return list
    }

    fun getViewModel():WeatherMainViewModel = obtainViewModel(WeatherMainViewModel::class.java,dataSource)
}
