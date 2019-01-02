package com.example.module_weather

import androidx.databinding.Observable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_weather.entity.weather.ResponseWeatherData
import kotlinx.android.synthetic.main.weather_main_activity.*
import javax.inject.Inject

class WeatherMainActivity : BaseActivity() {

    @Inject
    lateinit var weatherMainViewModel: WeatherMainViewModel

    @Inject
    lateinit var dataSource: WeatherDataSource

    private lateinit var weatherForecastRecyclerAdapter: WeatherForecastRecyclerAdapter

    override fun getLayout(): Int {
        return R.layout.weather_main_activity
    }

    override fun initComponent() {
        DaggerWeatherAppComponents
            .builder()
            .weatherAppModules(WeatherAppModules(this))
            .build()
            .inject(this)
    }

    override fun initData() {
        RetrofitManager.instance.init(applicationContext)

        weatherMainViewModel.apply {
            weatherData.addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                    var data:ResponseWeatherData = weatherData.get() as ResponseWeatherData
                    var layoutManager = LinearLayoutManager(this@WeatherMainActivity)
                    weatherForecastRecyclerAdapter = WeatherForecastRecyclerAdapter(this@WeatherMainActivity,data.forecast)
                    weather_forecast_list.adapter = weatherForecastRecyclerAdapter
                    weather_forecast_list.layoutManager = layoutManager
                }
            })
        }

        weatherMainViewModel.queryWeatherInfo()
    }
}
