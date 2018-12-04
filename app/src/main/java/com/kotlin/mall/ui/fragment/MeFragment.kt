package com.kotlin.mall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.mall.R
import kotlinx.android.synthetic.main.fragment_me.*

/**
 * "我的"界面
 */
class MeFragment :BaseFragment(),View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me,null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    /**
     *  初始化视图
     */
    private fun initView() {

        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)
        mWaitPayOrderTv.onClick(this)
        mWaitConfirmOrderTv.onClick(this)
        mCompleteOrderTv.onClick(this)
        mAllOrderTv.onClick(this)
        mAddressTv.onClick(this)
        mShareTv.onClick(this)
        mSettingTv.onClick(this)
    }


    override fun onStart() {
        super.onStart()
        loadData()
    }

    /**
     * 加载初始化数据
     */
    private fun loadData() {


    }


    /**
     * 点击事件
     */
    override fun onClick(view: View) {

        when(view.id){
            R.id.mUserIconIv,R.id.mUserNameTv ->{

            }

            R.id.mWaitPayOrderTv -> {

            }

            R.id.mWaitConfirmOrderTv -> {

            }

            R.id.mCompleteOrderTv -> {

            }

            R.id.mAllOrderTv -> {

            }

            R.id.mAddressTv -> {

            }

            R.id.mShareTv -> {

            }

            R.id.mSettingTv -> {

            }
        }
    }
}