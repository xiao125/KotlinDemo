package com.kotlin.user.injection.component

import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * 用户模块Component （注入器，连接目标类和依赖实例的桥梁，必须有一个Component管理全局实例）
 *
 *  Component ： 1. 通过modeules属性加入多个Module
 *               2. 依赖关系通过dependencies属性添加
 *
 */
@Component(modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)
}