package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.LoginReq
import com.kotlin.user.data.protocol.RegisterReq
import com.kotlin.user.data.protocol.UserInfo
import org.intellij.lang.annotations.JdkConstants
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * 用户相关 接口
 */
interface UserApi {

    /**
     * 用户注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>

    /**
        用户登录
     */
    @POST("userCenter/login")
    fun login(@Body req: LoginReq):Observable<BaseResp<UserInfo>>
}