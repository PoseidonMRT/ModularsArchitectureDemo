package com.example.module_weather

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
class WeatherMainViewModel(private val context: Application, private val dataSource: DataSource) :
    AndroidViewModel(context) {

}