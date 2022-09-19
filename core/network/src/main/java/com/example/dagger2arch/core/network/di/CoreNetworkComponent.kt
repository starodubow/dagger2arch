package com.example.dagger2arch.core.network.di

import android.content.Context
import android.util.Log
import com.example.app_api.di.ApplicationContextComponentHolder
import com.example.dagger2arch.core.data.data.UserData
import com.example.dagger2arch.core.data.di.CoreDataComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreNetworkModule::class],
    dependencies = [CoreNetworkDependencies::class]
)
abstract class CoreNetworkComponent : CoreNetworkApi {

    companion object {

        private var coreNetworkComponent: CoreNetworkComponent? = null

        fun get(): CoreNetworkComponent {
            if (coreNetworkComponent == null) {
                Log.d("AppTag", "CoreNetworkComponent init")
                synchronized(CoreNetworkComponent::class.java) {
                    if (coreNetworkComponent == null) {
                        coreNetworkComponent = DaggerCoreNetworkComponent.factory()
                            .create(dependencies = object : CoreNetworkDependencies {
                                override fun provideApplicationContext(): Context {
                                    return ApplicationContextComponentHolder
                                        .get()
                                        .provideApplicationContext()
                                }

                                override fun provideUserData(): UserData {
                                    return CoreDataComponent.get().provideUserData()
                                }

                            })
                    }
                }
            }
            return coreNetworkComponent!!
        }

    }

    @Component.Factory
    interface Factory {
        fun create(dependencies: CoreNetworkDependencies): CoreNetworkComponent
    }
}