package com.kotlin.base.ui.fragment

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 *  Fragment基类，业务相关
 *  对于可以重写的函数，都需要显示的指明，使用的是open关键字。如果没有，在子类中声明跟父类相同的方法是非法的。
 */
abstract open  class BaseMvpFragment<T:BasePresenter<*>> : BaseFragment(),BaseView {

   //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var  mActivityCompiler:ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initActivityInjection()
        injectComponent()
        //初始加载框
        mLoadingDialog = ProgressLoading.create(context)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /**
     * Dagger 注册
     */
    protected abstract fun injectComponent()

   /*
       初始Activity Component
    */
   private fun initActivityInjection() {
      mActivityCompiler = DaggerActivityComponent.builder()
              .appComponent((activity.application as BaseApplication).appComponent)
              .activityModule(ActivityModule(activity))
              .lifecycleProviderModule(LifecycleProviderModule(this))
              .build()
   }

    /**
     * 显示加载框，默认实现
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /**
     * 隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /**
     * 错误信息提示，默认实现
     */
    override fun onError(text: String) {
        toast(text)
    }

}