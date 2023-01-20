package com.example.dagger2arch.di

import android.util.Log
import com.example.dagger2arch.MainActivity
import com.example.dagger2arch.MainApplication
import com.example.dagger2arch.core.common.CoreDependenciesMapProvider
import com.example.dagger2arch.core.data.di.CoreDataComponent
import com.example.dagger2arch.core.data.di.external.CoreDataDependencies
import com.example.dagger2arch.core.network.di.external.CoreNetworkDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CoreDependenciesModule::class
    ]
)
abstract class AppComponent :
    CoreDependenciesMapProvider,
    CoreNetworkDependencies,
    CoreDataDependencies {

    companion object {
        private var appComponent: AppComponent? = null

        fun init() {
            if (appComponent == null) {
                Log.d("AppTag", "AppComponent init")
                synchronized(CoreDataComponent::class.java) {
                    if (appComponent == null) {
                        appComponent = DaggerAppComponent
                            .builder()
                            .build()
                    }
                }
            }
        }

        fun get(): AppComponent {
            return checkNotNull(appComponent) {
                "AppComponent was not initialized"
            }
        }
    }

    abstract fun inject(application: MainApplication)
    abstract fun inject(activity: MainActivity)


    @Component.Builder
    interface Builder {

        fun build(): AppComponent

    }

}
