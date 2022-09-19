package com.example.app_api.di

import android.util.Log

object ApplicationContextComponentHolder {
    private var applicationContextComponent: ApplicationContextComponent? = null

    fun init(dependencies: ApplicationContextDependencies) {
        Log.i("ApplicationContextComponentHolder", "init()")
        if (applicationContextComponent == null) {
            synchronized(ApplicationContextComponentHolder::class.java) {
                if (applicationContextComponent == null) {
                    Log.i("ApplicationContextComponentHolder", "initAndGet()")
                    applicationContextComponent =
                        ApplicationContextComponent.initAndGet(dependencies)
                }
            }
        }
    }

    fun get(): ApplicationContextApi {
        return checkNotNull(applicationContextComponent) {
            "PurchaseComponent was not initialized!"
        }
    }

    fun release() {
        Log.i("ApplicationContextComponentHolder", "release()")
        applicationContextComponent = null
    }
}