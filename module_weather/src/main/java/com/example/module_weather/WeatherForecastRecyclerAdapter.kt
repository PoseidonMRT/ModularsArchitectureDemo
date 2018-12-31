package com.example.module_weather

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module_weather.entity.weather.ResponseWeatherForcast

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
class WeatherForecastRecyclerAdapter(private val context: Context,private val datas:List<ResponseWeatherForcast>):RecyclerView.Adapter<WeatherForecastRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    public class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}