package com.kotlin.base.injection

import java.lang.annotation.Documented

import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * Activity级别 作用域
 *
 *  @Scope 同样用于自定义注解，可以通过@Scope自定义的注解来限定注解作用域，实现全局的单例
 *  @Singleton 是一个通过@Scope定义的注解，我们一般通过用来配合实现局部单例和全局单例的。事实上它本身不具备创建单例的能力
 *  是否能提供全局单例还要取决于对应的Component是否为一个全局对象。
 *
 *  kotlin中将 annotation 修饰符是注解声明，需放在类的前面
 *  注解的附加属性 @Retention 指定该注解是否存储在编译后的class文件中，以及它在运行时是否通过反射可见（默认都是true）
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class ActivityScope