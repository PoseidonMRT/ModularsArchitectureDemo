package com.example.commonsdk.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initComponent()
        initData()
    }

    abstract fun getLayout():Int
    abstract fun initData()
    abstract fun initComponent()
}
