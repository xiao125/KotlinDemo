package com.kotlin.user.presenter;

import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.user.presenter.view.RegisterView

/**
 * 用户注册Presenter
 */
class RegisterPresenter : BasePresenter<RegisterView>() {

    fun register(mobile:String,verifyCode:String){
        /**
         * 业务逻辑
         */

        mView.OnRegisterResult(true)
    }
}