package com.example.commonsdk.utils

import android.content.Context
import android.content.SharedPreferences

object PreferencesUtils {

    val PREFERENCE_NAME = "modular_app"

    /**
     * 存储字符串
     */
    fun putString(context: Context, key: String, value: String): Boolean {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        val editor = preferences.edit()
        editor.putString(key, value)
        return editor.commit()
    }

    /**
     * 读取字符串（带默认值的）
     */
    @JvmOverloads
    fun getString(context: Context, key: String, defaultValue: String? = null): String? {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        return preferences.getString(key, defaultValue)
    }

    /**
     * 存储整型数字
     */
    fun putInt(context: Context, key: String, value: Int): Boolean {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        val editor = preferences.edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    /**
     * 读取整型数字（带默认值的）
     */
    @JvmOverloads
    fun getInt(context: Context, key: String, defaultValue: Int = -1): Int {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        return preferences.getInt(key, defaultValue)
    }

    /**
     * 存储长整型数字
     */
    fun putLong(context: Context, key: String, value: Long): Boolean {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        val editor = preferences.edit()
        editor.putLong(key, value)
        return editor.commit()
    }

    /**
     * 读取长整型数字（带默认值的）
     */
    @JvmOverloads
    fun getLong(context: Context, key: String, defaultValue: Long = -0x1): Long {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        return preferences.getLong(key, defaultValue)
    }

    /**
     * 存储Float数字
     */
    fun putFloat(context: Context, key: String, value: Float): Boolean {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        val editor = preferences.edit()
        editor.putFloat(key, value)
        return editor.commit()
    }

    /**
     * 读取Float数字（带默认值的）
     */
    @JvmOverloads
    fun getFloat(context: Context, key: String, defaultValue: Float = -1.0f): Float {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        return preferences.getFloat(key, defaultValue)
    }

    /**
     * 存储boolean类型数据
     */
    fun putBoolean(context: Context, key: String, value: Boolean): Boolean {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        return editor.commit()
    }

    /**
     * 读取boolean类型数据（带默认值的）
     */
    @JvmOverloads
    fun getBoolean(context: Context, key: String, defaultValue: Boolean = false): Boolean {
        val preferences = context.getSharedPreferences(PREFERENCE_NAME, 0)
        return preferences.getBoolean(key, defaultValue)
    }

    /**
     * 清除数据
     */
    fun clearPreferences(context: Context): Boolean {
        val pref = context.getSharedPreferences(PREFERENCE_NAME, 0)
        val editor = pref.edit()
        editor.clear()
        return editor.commit()
    }
}
