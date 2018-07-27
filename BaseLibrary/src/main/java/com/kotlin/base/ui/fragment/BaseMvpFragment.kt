package com.kotlin.base.ui.fragment

import android.os.Bundle
import android.os.PersistableBundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

/**
 *  Activity基类，业务相关
 *  对于可以重写的函数，都需要显示的指明，使用的是open关键字。如果没有，在子类中声明跟父类相同的方法是非法的。
 */
 open abstract class BaseMvpFragment<T:BasePresenter<*>> : BaseFragment(),BaseView {

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
    }

   //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var  mActivityCompiler:ActivityComponent

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      initActivityInjection()
      injectComponent()
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

}