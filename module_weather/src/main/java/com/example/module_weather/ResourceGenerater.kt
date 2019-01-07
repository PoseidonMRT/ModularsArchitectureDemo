package com.example.module_weather

/**
 * @author
 * @Date 2019/1/2
 * @description
 * @since 1.0.0
 */
class ResourceGenerater {

    companion object {
        fun generateIcon(type: String, isBiggerIcon: Boolean): Int {
            var resId: Int = 0
            when (type) {
                "阴" -> {
                    if (isBiggerIcon) {
                        resId = R.drawable.weather_vector_drawable_icon_white
                    } else {
                        resId = R.drawable.weather_vector_drawable_icon_black
                    }
                }
                "多云" -> {
                    if (isBiggerIcon) {
                        resId = R.drawable.weather_vector_drawable_icon_cloudy_white
                    } else {
                        resId = R.drawable.weather_vector_drawable_icon_cloudy_black
                    }
                }
                "晴" -> {
                    if (isBiggerIcon) {
                        resId = R.drawable.weather_vector_drawable_icon_sunny_white
                    } else {
                        resId = R.drawable.weather_vector_drawable_icon_sunny_black
                    }
                }
                "小雨" -> {
                    if (isBiggerIcon) {
                        resId = R.drawable.weather_vector_drawable_icon_cloudy_rain_white
                    } else {
                        resId = R.drawable.weather_vector_drawable_icon_cloudy_rain_black
                    }
                }
                else -> {
                    if (isBiggerIcon) {
                        resId = R.drawable.weather_vector_drawable_icon_white
                    } else {
                        resId = R.drawable.weather_vector_drawable_icon_black
                    }
                }
            }
            return resId
        }

        fun generateColor(type: String): Int {
            var resId: Int = 0
            when (type) {
                "阴" -> {
                    resId = R.color.weather_color_1f88ca
                }
                "多云" -> {
                    resId = R.color.weather_color_cccccc
                }
                "晴" -> {
                    resId = R.color.weather_color_ffd700
                }
                else -> {
                    resId = R.color.weather_color_1f88ca
                }
            }
            return resId
        }
    }
}
