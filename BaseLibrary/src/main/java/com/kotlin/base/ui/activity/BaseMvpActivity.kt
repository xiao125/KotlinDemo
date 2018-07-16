package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.presenter.view.BaseView

/**
 *  Activity基类，业务相关
 *  对于可以重写的函数，都需要显示的指明，使用的是open关键字。如果没有，在子类中声明跟父类相同的方法是非法的。
 */
 open class BaseMvpActivity<T:BasePresenter<*>> : BaseActivity(),BaseView {

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