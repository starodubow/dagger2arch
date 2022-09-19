package com.example.dagger2arch.di

import android.util.Log
import com.example.dagger2arch.MainActivity
import com.example.dagger2arch.MainApplication
import com.example.dagger2arch.core.data.data.UserData
import com.example.dagger2arch.core.data.di.CoreDataComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class],
    dependencies = [AppComponentDependencies::class]
)
abstract class AppComponent {

    companion object {
        private var appComponent: AppComponent? = null

        fun init() {
            if (appComponent == null) {
                Log.d("AppTag", "AppComponent init")
                synchronized(CoreDataComponent::class.java) {
                    if (appComponent == null) {
                        appComponent = DaggerAppComponent
                            .builder()
                            .dependencies(dependencies = object : AppComponentDependencies {
                                override fun provideUserData(): UserData {
                                    return CoreDataComponent.get().provideUserData()
                                }

                            })
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

        fun dependencies(dependencies: AppComponentDependencies): Builder

        fun build(): AppComponent

    }

}
