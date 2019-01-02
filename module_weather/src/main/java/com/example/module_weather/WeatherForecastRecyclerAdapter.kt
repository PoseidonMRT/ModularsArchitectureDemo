package com.example.module_weather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module_weather.entity.weather.ResponseWeatherForcast

/**
 * @author
 * @Date 2018/12/31
 * @description
 * @since 1.0.0
 */
class WeatherForecastRecyclerAdapter(private val context: Context, private val datas: List<ResponseWeatherForcast>) :
    RecyclerView.Adapter<WeatherForecastRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(context).inflate(
            R.layout.weather_main_recycler_item_layout,
            parent, false
        )
    )

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dateTextView.text = datas[position].date
        var lowtemp = datas[position].low.replace("低温","").replace("℃","").trim()
        var highTemp = datas[position].high.replace("高温","").replace("℃","").trim()
        holder.temperatureTextView.text = lowtemp +"~"+ highTemp
        holder.iconImageView.setImageResource(ResourceGenerater.generateIcon(datas[position].type,false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var dateTextView:TextView = itemView.findViewById(R.id.weather_main_recycler_item_date)
        var temperatureTextView:TextView = itemView.findViewById(R.id.weather_main_recycler_item_temperature)
        var iconImageView:ImageView = itemView.findViewById(R.id.weather_main_recycler_item_icon)
     }
}