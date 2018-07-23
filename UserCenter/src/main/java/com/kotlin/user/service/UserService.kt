package com.kotlin.user.service.impl

import rx.Observable

/**
 * 用户模块 业务接口
 */
interface UserService {

    //用户注册
    fun register(mobile:String,pwd:String,verifyCode:String):Observable<Boolean>
}