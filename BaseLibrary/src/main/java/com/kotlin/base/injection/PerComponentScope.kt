package com.kotlin.base.injection

import java.lang.annotation.Documented

import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * 每个业务级的  Scope
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class PerComponentScope