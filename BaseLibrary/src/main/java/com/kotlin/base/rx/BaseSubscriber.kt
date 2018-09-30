package com.kotlin.base.rx
import com.kotlin.base.presenter.view.BaseView
import rx.Subscriber

/**
 * Rx订阅默认实现   Subject 既可以是一个 Observer 也可以是一个 Observerable，它是连接 Observer 和Observerable的桥梁
 */
open class BaseSubscriber<T>(val baseView: BaseView): Subscriber<T>() {
    override fun onNext(t: T) {
        //RxJava的事件回调方法，针对普通事件
    }

    override fun onCompleted() {
        //事件队列完结
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        //事件队列异常
        baseView.hideLoading()
        if(e is BaseException){
            baseView.onError(e.msg)
        }
    }
}