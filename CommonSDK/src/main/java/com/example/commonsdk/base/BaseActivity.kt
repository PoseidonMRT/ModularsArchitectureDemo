package com.example.commonsdk.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initComponent()
        initViewModel()
        initViewState()
        initData()
    }

    /**
     * return layout res id
     */
    abstract fun getLayout():Int

    /**
     * init dagger2 components
     */
    abstract fun initComponent()

    /**
     * init android ViewModel
     */
    abstract fun initViewModel()

    /**
     * init View listener and state
     */
    abstract fun initViewState()

    /**
     * init data
     */
    abstract fun initData()
}
