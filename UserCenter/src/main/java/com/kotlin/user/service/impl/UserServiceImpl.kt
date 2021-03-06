package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.convert
import com.kotlin.base.ext.convertBoolean
import com.kotlin.base.rx.BaseException
import com.kotlin.base.rx.BaseFuncBoolean
import com.kotlin.user.data.protocol.UserInfo
import com.kotlin.user.data.respository.UserRepository
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * 用户模块业务实现类
 *  @Inject  标记需要注入的属性
 *
 *  flatMap操作符将Observable发射的数据集合变换为Observable集合，然后将这些Observable发射的数据
      平坦化地放进一个单独的 Observable
 */
class UserServiceImpl @Inject constructor() :UserService {

    @Inject
    lateinit var repository:UserRepository

    /**
     * 注册
     */
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        return repository.register(mobile,pwd,verifyCode).convertBoolean() //进行网络请求
    }

    /**
     * 登录
     */
    override  fun  login(mobile: String, pwd: String, pushId: String) : Observable<UserInfo>{
        return repository.login(mobile,pwd,pushId).convert()
    }


    /**
     * 忘记密码
     */
    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return  repository.forgetPwd(mobile, verifyCode).convertBoolean()
    }


    /**
     * 重置密码
     */
    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        return  repository.resetPwd(mobile,pwd).convertBoolean()
    }

    /**
     * 修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return repository.editUser(userIcon,userName,userGender,userSign).convert()
    }

}