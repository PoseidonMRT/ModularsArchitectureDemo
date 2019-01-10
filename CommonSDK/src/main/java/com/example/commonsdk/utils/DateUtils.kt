package com.example.commonsdk.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * @author
 * @Date 2019/1/10
 * @description
 * @since 1.0.0
 */
object DateUtils {

    fun getOldDate(distanceDay: Int): String {
        val dft = SimpleDateFormat("yyyyMMdd")
        val beginDate = Date()
        val date = Calendar.getInstance()
        date.time = beginDate
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay)
        var endDate: Date? = null
        try {
            endDate = dft.parse(dft.format(date.getTime()))
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return dft.format(endDate)
    }
}