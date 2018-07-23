package com.kotlin.base.ext

import com.kotlin.base.rx.BaseSubscriber
import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

//Kotlin通用扩展


/**
 *  扩展Observable执行
 */
 fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
}