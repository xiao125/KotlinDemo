package com.kotlin.user.ui.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.injection.component.DaggerUserComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import dagger.internal.DaggerCollections
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 注册界面
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    //RegisterView 接口
    override fun OnRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    @SuppressLint("MissingSuperCall") //忽略Lint警告
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_tes)

        initInjection()
        mRegisterBtn.setOnClickListener{
            Log.w("TAG","点击了")
            mPresenter.register(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
        }
    }
     private fun initInjection(){
        DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
         mPresenter.mView = this

     }

}


