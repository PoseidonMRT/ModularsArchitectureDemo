package com.example.module_weather

import android.widget.Toast
import androidx.databinding.Observable
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonsdk.RouterHub
import com.example.commonsdk.base.BaseActivity
import com.example.module_weather.entity.weather.ResponseWeatherData
import kotlinx.android.synthetic.main.weather_main_activity.*

@Route(path = RouterHub.WEATHER_MAIN_ACTIVITY)
class WeatherMainActivity : BaseActivity() {

    lateinit var weatherMainViewModel: WeatherMainViewModel

    private lateinit var weatherForecastRecyclerAdapter: WeatherForecastRecyclerAdapter

    override fun getLayout(): Int {
        return R.layout.weather_main_activity
    }

    override fun initComponent() {
    }

    override fun initViewModel() {
        weatherMainViewModel = ViewModelFactory.getInstance(application).create(WeatherMainViewModel::class.java)

        weatherMainViewModel.apply {

            weatherData.addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                    var data:ResponseWeatherData = weatherData.get() as ResponseWeatherData
                    var todayWeatherType:String = data.forecast[0].type

                    weather_main_weather_type_tv.text = todayWeatherType
                    weather_main_temperature_tv.text = data.wendu
                    weather_main_weather_type_iv.setImageResource(ResourceGenerater.generateIcon(todayWeatherType,true))

                    var layoutManager = LinearLayoutManager(this@WeatherMainActivity)
                    weatherForecastRecyclerAdapter = WeatherForecastRecyclerAdapter(this@WeatherMainActivity,data.forecast)
                    weather_forecast_list.adapter = weatherForecastRecyclerAdapter
                    weather_forecast_list.layoutManager = layoutManager
                }
            })

            error.addOnPropertyChangedCallback(object :Observable.OnPropertyChangedCallback(){
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    var msg:String = error.get() as String
                    Toast.makeText(this@WeatherMainActivity,msg,Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    override fun initViewState() {

    }

    override fun initData() {
        weatherMainViewModel.queryWeatherInfo("成都")
    }
}
