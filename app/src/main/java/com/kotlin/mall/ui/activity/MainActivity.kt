package com.kotlin.mall.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.kotlin.base.common.AppManager
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.HomeFragment
import com.kotlin.mall.ui.fragment.MeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.text.FieldPosition
import java.util.*

class MainActivity : BaseActivity() {

    private var pressTime:Long = 0
    //Fragment 栈管理
    private val mStack = Stack<Fragment>()
    //主界面Fragment
    private  val mHomeFragment by lazy { HomeFragment() }
    //商品分类Fragment
    private  val mCategoryFragment by lazy { HomeFragment() }
    //购物车Fragment
    private  val mCartFragment by lazy { HomeFragment() }
    //消息Fragment
    private  val mMsgFragment by lazy { HomeFragment() }
    //"我的"Fragment
    private  val mMeFragment by lazy { MeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        initBottomNav()
        changeFragment(0)
        initObserve()
        loadCartSize()
    }

    /**
     *初始化Fragment栈管理
     */
    private fun  initFragment(){

        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContaier,mHomeFragment)
        manager.add(R.id.mContaier,mCategoryFragment)
        manager.add(R.id.mContaier,mCartFragment)
        manager.add(R.id.mContaier,mMsgFragment)
        manager.add(R.id.mContaier,mMeFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)
    }

    /**
     * 初始化底部导航切换事件
     */
    private fun initBottomNav(){

        mBottomNavBar.setTabSelectedListener(object :BottomNavigationBar.OnTabSelectedListener{

            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })

        mBottomNavBar.checkMsgBadge(false)
    }

    /**
     * 切换Tab，切换对应的Fragment
     */
    private fun changeFragment(position: Int){
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }

    /**
     * 初始化监听，购物车数量变化及消息标签是否显示
     */
    private fun initObserve(){

    }

    /**
     * 加载购物车数量
     */
    private fun loadCartSize(){

    }

    /**
     * 取消Bus事件监听
     */
    override fun onDestroy() {
        super.onDestroy()

    }


    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000){
            toast("再按一次退出程序")
            pressTime = time
        } else{
            AppManager.instance.exitApp(this)
        }
    }


}
