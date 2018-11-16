package com.kotlin.mall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.mall.R
import java.util.*

class MainActivity : BaseActivity() {

    private var pressTime:Long = 0;
    //Fragment 栈管理
    private val mStack = Stack<Fragment>()

    //主界面Fragment
    private  val mHomeFragment by lazy {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
