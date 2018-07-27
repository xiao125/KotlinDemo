package com.kotlin.base.ext

import android.view.View
import com.kotlin.base.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
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
 fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>){
    this.observeOn(AndroidSchedulers.mainThread()) //指定 Subscriber 的回调发生在主线程
            .compose(lifecycleProvider.bindToLifecycle()) //RxLifecycle 添加Rx生命周期管理,解决Rx内存泄露
            .subscribeOn(Schedulers.io()) //指定 subscribe() 发生在新的线程
            .subscribe(subscriber)  //subscribe 连接
}

/*
    扩展点击事件，参数为方法
     函数类型 method:() ->Unit
 */
fun View.onClick(method:() -> Unit):View{
    setOnClickListener { method() }
    return this
}

