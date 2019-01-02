package com.example.module_weather

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.module_weather.entity.ResponseMsg
import com.example.module_weather.entity.weather.ResponseWeatherData
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
class WeatherMainViewModel(private val context: Application, private val dataSource: DataSource) :
    AndroidViewModel(context) {

    var weatherData:ObservableField<ResponseWeatherData> = ObservableField()

    fun queryWeatherInfo(){
        (dataSource as WeatherDataSource).queryWeather("成都")
            .subscribe(object: Observer<ResponseMsg<ResponseWeatherData>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                     Log.e("TZB",e.message)
                }

                override fun onNext(t: ResponseMsg<ResponseWeatherData>) {
                    //update ui
                    Log.e("TZB",t.toString())
                    weatherData.set(t.data)
                }
            })
    }
}