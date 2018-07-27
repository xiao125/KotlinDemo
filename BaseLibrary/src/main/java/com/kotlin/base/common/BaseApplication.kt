package com.kotlin.base.common

import android.app.Application
import android.content.Context
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule
import dagger.Component

/**
 * Application 基类
 */
 open class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()
        context = this
    }

    private fun initAppInjection(){
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    /**
     *全局对象
     */
    companion object {
        lateinit var context: Context
    }
}