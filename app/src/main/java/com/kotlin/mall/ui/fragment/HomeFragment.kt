package com.kotlin.mall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.mall.R
import com.kotlin.mall.R.id.mSearchEt
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

/**
 * 主界面Fragment
 */
class HomeFragment : BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return  inflater!!.inflate(R.layout.fragment_home,null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initBanner()
        initNews()
        initDiscount()
        initTopic()


    }

    /**
     * 初始化视图
     */
    private fun initView(){
        mSearchEt.onClick {
            //跳转Activity
        }

        mScanIv.onClick {
            toast(R.string.coming_soon_tip)
        }

    }

    /**
     * 初始化Banner
     */
    private fun initBanner(){

    }

    /**
     * 初始化公告
     */
    private  fun initNews(){

    }

    /**
     * 初始化折扣
     */
    private fun initDiscount(){

    }

    /**
     * 初始化主题
     */
    private fun initTopic(){

    }
}