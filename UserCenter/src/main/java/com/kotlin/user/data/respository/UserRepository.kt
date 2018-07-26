package com.kotlin.user.data.respository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UserApi
import com.kotlin.user.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * 用户相关数据层
 */
class UserRepository @Inject constructor() {

    /**
     * 用户注册
     */
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<BaseResp<String>>{
        return  RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile,pwd,verifyCode))
    }
}