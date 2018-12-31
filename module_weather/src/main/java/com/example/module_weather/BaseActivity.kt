package com.example.module_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

public abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initData()
    }

    fun <T : ViewModel> obtainViewModel(viewModelClass: Class<T>,dataSource: DataSource) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application,dataSource)).get(viewModelClass)

    abstract fun getLayout():Int
    abstract fun initData()
}
