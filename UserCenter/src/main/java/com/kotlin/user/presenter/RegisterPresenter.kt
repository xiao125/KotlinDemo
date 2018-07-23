package com.kotlin.user.presenter;

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.impl.UserServiceImpl
import java.util.*

/**
 * 用户注册Presenter
 */
class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile:String,verifyCode:String,pwd:String){
        /**
         * 业务逻辑
         */
        val userService = UserServiceImpl()
        userService.register(mobile,verifyCode,pwd)
                .execute(object :BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        mView.OnRegisterResult(t)
                    }
                })


    }
}