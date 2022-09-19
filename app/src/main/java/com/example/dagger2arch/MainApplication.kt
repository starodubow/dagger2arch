package com.example.dagger2arch

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.app_api.di.ApplicationContextComponentHolder
import com.example.app_api.di.ApplicationContextDependencies
import com.example.dagger2arch.di.AppComponent

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("AppTag", "MainApplication onCreatr")
        appContext = applicationContext

        /**
         * Инициализация компонента, который проксирует AppContext для остальных модулей
         * */
        ApplicationContextComponentHolder.init(
            dependencies = object : ApplicationContextDependencies {
                override fun provideApplicationContext(): Context {
                    return appContext
                }
            }
        )

        AppComponent.init()
        AppComponent.get().inject(this)

    }


    companion object {
        lateinit var appContext: Context
            private set
    }
}