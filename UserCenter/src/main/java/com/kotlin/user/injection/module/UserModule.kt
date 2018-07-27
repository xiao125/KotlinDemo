package com.kotlin.user.injection.module

import com.kotlin.user.service.impl.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * 用户模块Module , module 是一个简单工厂，创建类实例的方法
 * @Module用于标注提供依赖的类
 *
 * @Provides 用于标注Module所标注的类中的方法，该方法在需要提供依赖时被调用
 */
@Module
class UserModule {

     @Provides
     fun provideUserService(userService:UserServiceImpl):UserService{
         return userService
     }
}