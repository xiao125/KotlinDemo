package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.presenter.view.BaseView

/**
 *  Activity基类，业务相关
 */
  class BaseMvpActivity<T:BasePresenter<*>> : BaseActivity(),BaseView {

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //lateinit var mActivityComponent: ActivityComponent

    lateinit var mPresenter: T


}