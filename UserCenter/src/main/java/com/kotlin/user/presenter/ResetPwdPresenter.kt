package com.kotlin.user.presenter

import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.view.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.ResetPwdView
import com.kotlin.user.service.impl.UserService
import javax.inject.Inject

/**
 * 重置密码Presenter
 */
class ResetPwdPresenter @Inject constructor(): BasePresenter<ResetPwdView>(){

    @Inject
    lateinit var userService: UserService

    fun resetPwd(mobile:String,pwd:String){
        if (!checkMetWork()){
            return
        }

        mView.showLoading()

        userService.resetPwd(mobile,pwd).execute(object :BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onResetPwdResult("重置密码成功")
            }
        },lifecycleProvider)
    }

}