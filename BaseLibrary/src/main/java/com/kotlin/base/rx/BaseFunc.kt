package com.kotlin.base.rx

import com.kotlin.base.common.ResultCode
import com.kotlin.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/*
    通用数据类型转换封装  Observable(被观察者) 决定什么时候触发事件以及触发怎样的事件, 在需要的时候通知Observer,
    Observer（观察者）,它决定事件触发的时候将有怎样的行为
 */
class BaseFunc<T>: Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status,t.message))
        }
        return Observable.just(t.data) //发射消息
    }
}
