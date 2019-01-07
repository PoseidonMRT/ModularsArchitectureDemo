package com.example.module_weather

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.commonservice.ResponseMsg
import com.example.module_weather.entity.weather.ResponseWeatherData
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
class WeatherMainViewModel(var context: Application) :
    AndroidViewModel(context) {

    var weatherDataSource: WeatherDataSource
    var error: ObservableField<String> = ObservableField()
    var weatherData: ObservableField<ResponseWeatherData> = ObservableField()

    init {
        weatherDataSource = WeatherDataSource()
    }

    fun queryWeatherInfo(cityName:String) {
        weatherDataSource.queryWeather(cityName)
            .subscribe(object : Observer<ResponseMsg<ResponseWeatherData>> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    error.set(e.message)
                }

                override fun onNext(t: ResponseMsg<ResponseWeatherData>) {
                    weatherData.set(t.data)
                }
            })
    }
}