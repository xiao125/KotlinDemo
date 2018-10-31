package com.kotlin.base.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.utils.GlideUtils
import com.kotlin.base.widgets.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

//Kotlin通用扩展


/**
 *  扩展Observable执行 （被观察者）
 *
 *   Scheduler : 线程控制器
 */
 fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>){
    this.subscribeOn(Schedulers.io()) //用于指定Observable自身在哪个线程上运行,
            observeOn(AndroidSchedulers.mainThread()) //用来指定Observer所运行的线程，也就是发射出的数据在哪个线程上使用。一般情况下会指定在主线程中运行，这样就可以修改UI
            .compose(lifecycleProvider.bindToLifecycle()) //RxLifecycle 添加Rx生命周期管理,解决Rx内存泄露
            .subscribe(subscriber)  //subscribe 连接
}

/*
    扩展点击事件，参数为方法
     函数类型 method:() ->Unit
 */
fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(com.kotlin.base.rx.BaseFunc())
}

/*
    扩展Boolean类型数据转换
 */
fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(com.kotlin.base.rx.BaseFuncBoolean())
}

/*
    扩展点击事件
 */
fun View.onClick(listener:View.OnClickListener):View{
    setOnClickListener(listener)
    return this
}

/*
    扩展点击事件，参数为方法
 */
fun View.onClick(method:() ->Unit):View{
    setOnClickListener{method()}
    return  this
}

/**
 * 扩展Button可用性
 * lambda表达式 : 定义了一个方法，我们必须使用大括号包围，然后在箭
  头的左边指定参数，在箭头的右边返回函数执行的结果。如果左边的参数没有使用
   到，我们甚至可以省略左边的参数
 */
fun Button.enable(et:EditText,method: () -> Boolean){
    val  btn = this
    et.addTextChangedListener(object: DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

/**
 * ImageView加载网络图片
 */
fun ImageView.loadUrl(url:String){
    GlideUtils.loadImage(context,url,this)
}






