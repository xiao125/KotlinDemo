package com.kotlin.user.injection.component

import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.*
import dagger.Component

/**
 * 用户模块Component （注入器，连接目标类和依赖实例的桥梁，必须有一个Component管理全局实例）
 * 被Component标注的接口在编译时会生成该接口的实现类
 *  Component ： 1. 通过modeules属性加入多个Module
 *               2. 依赖关系通过dependencies属性添加
 *
 */

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserInfoActivity)

}