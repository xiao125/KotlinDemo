package com.kotlin.user.presenter

import com.kotlin.base.common.ResultCode
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.ForgetPwdView
import com.kotlin.user.service.impl.UserService
import java.util.*
import javax.inject.Inject

/**
 * 忘记密码Presenter
 */
class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService: UserService

    fun forgetPwd(mobile:String,verifyCode:String){
        if (!checkMetWork()){
            return
        }
        mView.showLoading()

        userService.forgetPwd(mobile,verifyCode).execute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onForgetPwdResult("验证成功")
            }
        },lifecycleProvider)

    }


}