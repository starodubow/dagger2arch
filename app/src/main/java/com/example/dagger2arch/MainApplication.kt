package com.example.dagger2arch

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.dagger2arch.core.common.CoreApplication
import com.example.dagger2arch.core.common.CoreDependenciesMapProvider
import com.example.dagger2arch.di.AppComponent

class MainApplication : Application(),
    CoreApplication {

    override fun onCreate() {
        super.onCreate()
        Log.d("AppTag", "MainApplication onCreate")
        appContext = applicationContext

        AppComponent.init()
        AppComponent.get().inject(this)

    }

    companion object {
        lateinit var appContext: Context
            private set
    }

    override fun getCoreDependenciesMapProvider(): CoreDependenciesMapProvider {
        return AppComponent.get()
    }
}