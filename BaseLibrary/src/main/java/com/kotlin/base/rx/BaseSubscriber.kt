package com.kotlin.base.rx
import rx.Subscriber

/**
 * Rx订阅默认实现
 */
open class BaseSubscriber<T>: Subscriber<T>() {
    override fun onNext(t: T) {
        //RxJava的事件回调方法，针对普通事件
    }

    override fun onCompleted() {
        //事件队列完结
    }

    override fun onError(e: Throwable?) {
        //事件队列异常
    }
}