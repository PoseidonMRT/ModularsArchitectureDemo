package com.example.module_weather

import dagger.Component
import javax.inject.Singleton

/**
 * @author
 * @Date 2019/1/2
 * @description
 * @since 1.0.0
 */
@Singleton
@Component(modules = arrayOf(WeatherAppModules::class))
interface WeatherAppComponents {
    fun inject(context:WeatherMainActivity)
}