package com.example.dagger2arch.core.data.di

import android.content.Context
import android.util.Log
import com.example.app_api.external.ApplicationContextComponentHolder
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreDataModule::class],
    dependencies = [
        CoreDataDependencies::class
    ]
)
abstract class CoreDataComponent : CoreDataApi {
    companion object {
        private var coreDataComponent: CoreDataComponent? = null

        fun get(): CoreDataComponent {
            if (coreDataComponent == null) {
                Log.d("AppTag", "CoreDataComponent init")
                synchronized(CoreDataComponent::class.java) {
                    if (coreDataComponent == null) {
                        coreDataComponent = DaggerCoreDataComponent.factory()
                            .create(dependencies = object : CoreDataDependencies {
                                override fun provideApplicationContext(): Context {
                                    return ApplicationContextComponentHolder
                                        .get()
                                        .provideApplicationContext()
                                }
                            })
                    }
                }
            }
            return coreDataComponent!!
        }
    }

    @Component.Factory
    interface Factory {
        fun create(dependencies: CoreDataDependencies): CoreDataComponent
    }
}