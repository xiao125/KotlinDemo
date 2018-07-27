package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.user.data.respository.UserRepository
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * 用户模块业务实现类
 */
class UserServiceImpl @Inject constructor() :UserService {

    @Inject
    lateinit var repository:UserRepository

    /**
     * 注册
     */
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        return repository.register(mobile,pwd,verifyCode)
                .flatMap(BaseFuncBoolean())
    }




}