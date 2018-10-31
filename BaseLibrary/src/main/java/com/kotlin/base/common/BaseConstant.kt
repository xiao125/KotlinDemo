package com.kotlin.base.common

/**
 * 基础常量
 *
 * "object"修饰静态类，或"companion object"修饰静态方法，都可以使用类名.方法名的形式调用
 *
 * const val 可见性为public final static，可以直接访问。
 * val 可见性为private final static，并且val 会生成方法getNormalObject() ，通过方法调用访问。
 */
class BaseConstant {
    companion object {
        //本地服务器地址
        const val SERVER_ADDRESS = "http://10.28.14.168:8080"
        //sp表名
        const  val  TABLE_PREFS = "Kotlin_mall"
        //Token Key
        const val KEY_SP_TOKEN = "token"
    }
}