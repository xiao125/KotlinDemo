package com.kotlin.base.injection.module

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import com.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity){

    @Provides
    fun  provideActivity():Activity{
        return this.activity
    }

}