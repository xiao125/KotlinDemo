package com.kotlin.base.common

import android.app.Application
import android.content.Context
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule
import dagger.Component
import dagger.internal.DaggerCollections

/**
 * Application 基类
 *
 * lateinit 只用于变量 var，  lateinit 则用于只能生命周期流程中进行获取或者初始化的变量
 */
 open class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context = this

        //ARouter初始化
//        ARouter.openLog()    // 打印日志
//        ARouter.openDebug()
//        ARouter.init(this)
    }

    private fun initAppInjection(){
        appComponent =  DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

    /**
     *  全局伴生对象
     */
    companion object {
        lateinit var context: Context
    }
}