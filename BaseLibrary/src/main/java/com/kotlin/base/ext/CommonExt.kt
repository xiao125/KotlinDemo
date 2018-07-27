package com.kotlin.base.ext

import com.kotlin.base.rx.BaseSubscriber
import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

//Kotlin通用扩展


/**
 *  扩展Observable执行 （被观察者）
 *
 *   Scheduler : 线程控制器
 */
 fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){
    this.observeOn(AndroidSchedulers.mainThread()) //指定 Subscriber 的回调发生在主线程
            .subscribeOn(Schedulers.io()) //指定 subscribe() 发生在新的线程
            .subscribe(subscriber)  //subscribe 连接
}