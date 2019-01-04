package com.example.commonsdk.app

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

/**
 * @author
 * @Date 2019/1/4
 * @description
 * @since 1.0.0
 */
class ApplicationManifestParser(var context: Context) {

    private val APPLICATION_VALUE: String = "ModuleApplication"

    fun parse(): ArrayList<ApplicationLifecycleDelegate> {
        var appLifecycleList: ArrayList<ApplicationLifecycleDelegate> = arrayListOf()
        try {
            var applicationInfo: ApplicationInfo =
                context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            if (null != applicationInfo.metaData) {
                for (key in applicationInfo.metaData.keySet()) {
                    if (APPLICATION_VALUE == applicationInfo.metaData.get(key)) {
                        appLifecycleList.add(parseAppLifecycleDelegate(key))
                    }
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            throw RuntimeException("Unable to find metadata to parse ConfigModule", e)
        }
        return appLifecycleList
    }

    private fun parseAppLifecycleDelegate(className: String): ApplicationLifecycleDelegate {
        var clazz: Class<*> = Class.forName(className)
        val appLifeCycleDelegate: Any
        appLifeCycleDelegate = clazz.newInstance()
        if (appLifeCycleDelegate !is ApplicationLifecycleDelegate) {
            throw RuntimeException("Expected instanceof ConfigModule, but found: $appLifeCycleDelegate")
        }
        return appLifeCycleDelegate
    }
}