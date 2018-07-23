package com.kotlin.base.data.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  Retrofit工厂，单例
 */
class RetrofitFactory {

    /**
     * companion object 伴生对象 ,以需要使用companion object来声明static变量,伴生对象与单例模式相关
     */
    companion object { //单例实现
        val instance:RetrofitFactory by lazy {
            RetrofitFactory()
        }
    }

    private val retrofit:Retrofit
    private val interceptor:Interceptor

    init { //初始化代码块以init关键字开头

        //通用拦截
        interceptor = Interceptor {
            chain -> val request = chain.request()
                .newBuilder()
                .addHeader("Content_Type","application/json")
                .addHeader("charset","UTF-8")
                .build()
            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()

    }

    //OkHttp创建
    private fun initClient():OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()
    }

    /**
     * 日志拦截
     */
    private fun initLogInterceptor():HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * 具体服务实例化
     */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }


}