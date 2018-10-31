package com.kotlin.base.common

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Activity管理器
 */
class AppManager private  constructor(){

    private  val  activityStack : Stack<Activity> = Stack()

    //单例
    companion object {
        val instance:AppManager by lazy { AppManager() }
    }

    /**
     * Activity入栈
     */
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /**
     * Activity出栈
     */

    fun finishActivity(activity: Activity){
        activityStack.remove(activity)
    }

    /**
     * 获取当前栈顶
     */

    fun currentActivity():Activity{
        return  activityStack.lastElement()
    }

    /**
     * 清理栈
     */

    fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }


     /**
     * 退出应用程序
     */
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACCOUNT_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}
