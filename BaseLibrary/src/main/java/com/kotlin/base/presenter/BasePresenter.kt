package com.kotlin.base.presenter.view

/**
 *  MVP中P层 基类
 *  lateinit 和 lazy 是 Kotlin 中的两种不同的延迟初始化的实现
 *  lateinit 只用于变量 var，而 lazy 只用于常量 val
 */
open class BasePresenter<T:BaseView> {

    lateinit var mView:T   //lateinit 则用于只能生命周期流程中进行获取或者初始化的变量
}