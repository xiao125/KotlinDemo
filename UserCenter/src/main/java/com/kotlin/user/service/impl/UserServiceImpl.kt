package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
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
                .flatMap(object :Func1<BaseResp<String>,Observable<Boolean>>{
                    override fun call(t: BaseResp<String>): Observable<Boolean> {
                       if (t.status !=0){
                         return Observable.error(BaseException(t.status,t.message))
                       }
                       return Observable.just(true)
                    }
                })
    }




}