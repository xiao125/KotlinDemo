package com.kotlin.base.presenter.view

import android.content.Context
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 *  MVP中P层 基类
 *  lateinit 和 lazy 是 Kotlin 中的两种不同的延迟初始化的实现
 *  lateinit 只用于变量 var，而 lazy 只用于常量 val
 */
open class BasePresenter<T:BaseView> {

    lateinit var mView:T   //lateinit 则用于只能生命周期流程中进行获取或者初始化的变量

    //Dagger注入，Rx生命周期管理
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var  context: Context


    /**
     * 检查网络是否可用
     */
    fun checkMetWork():Boolean{
        if (NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}