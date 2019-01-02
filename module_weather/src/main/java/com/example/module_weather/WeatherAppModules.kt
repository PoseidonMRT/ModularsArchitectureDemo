package com.example.module_weather

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author
 * @Date 2019/1/2
 * @description
 * @since 1.0.0
 */
@Module
class WeatherAppModules(var context: Context) {

    init {
        RetrofitManager.instance.init(context.applicationContext)
    }

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun providerWeatherDataSource():WeatherDataSource{
        return WeatherDataSource()
    }

    @Singleton
    @Provides
    fun provideWeatherMainViewModel(context: Context,dataSource: WeatherDataSource): WeatherMainViewModel {
        return ViewModelFactory.getInstance(context.applicationContext as Application,dataSource).create(WeatherMainViewModel::class.java)
    }
}