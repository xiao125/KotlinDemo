package com.kotlin.user.injection.module

import com.kotlin.user.service.impl.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * 用户模块Module , module 是一个简单工厂，创建类实例的方法
 */
@Module
class UserModule {

     @Provides
     fun provideUserService(userService:UserServiceImpl):UserService{
         return userService
     }
}