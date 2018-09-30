package com.kotlin.user.presenter;

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.impl.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import java.util.*
import javax.inject.Inject

/**
 * 用户注册Presenter
 *  1.关键字constructor：在Java中，构造方法名须和类名相同；而在Kotlin中，是通过constructor关键字来标明的
 *  2.当constructor关键字没有注解和可见性修饰符作用于它时，constructor关键字可以省略（当然，如果有这些修饰时，
 *    是不能够省略的，并且constructor关键字位于修饰符后面）
 *  3.关键字init：init{}它被称作是初始化代码块（Initializer Block）
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService:UserService

    fun register(mobile:String,verifyCode:String,pwd:String){
        if(!checkMetWork()){
            return
        }
        mView.showLoading()
        /**
         * 业务逻辑 ，接收 Observable.just(true) 发射的数据
         */
        userService.register(mobile,pwd,verifyCode)
                .execute(object :BaseSubscriber<Boolean>(mView){
                    override fun onNext(t: Boolean) {
                        if(t){
                            mView.OnRegisterResult("注册成功")
                        }
                    }
                },lifecycleProvider)
    }
}