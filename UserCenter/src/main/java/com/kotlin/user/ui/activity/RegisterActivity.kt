package com.kotlin.user.ui.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    //RegisterView 接口
    override fun OnRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    @SuppressLint("MissingSuperCall") //忽略Lint警告
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this
        mRegisterBtn.setOnClickListener{
            mPresenter.register("","","")
        }
    }
}


