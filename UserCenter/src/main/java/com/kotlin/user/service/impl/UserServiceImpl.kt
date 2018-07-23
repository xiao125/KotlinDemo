package com.kotlin.user.service.impl

import rx.Observable

/**
 * 用户模块业务实现类
 */
class UserServiceImpl :UserService {

    /**
     * 注册
     */
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return Observable.just(true)
    }




}