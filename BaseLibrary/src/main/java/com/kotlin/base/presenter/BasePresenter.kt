package com.kotlin.base.presenter.view

/**
 *  MVP中P层 基类
 */
class BasePresenter<T:BaseView> {

    lateinit var mView:T
}