package com.example.app_api.internal

import android.util.Log
import com.example.app_api.external.ApplicationContextApi
import com.example.app_api.external.ApplicationContextDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [ApplicationContextDependencies::class])
internal abstract class ApplicationContextComponent : ApplicationContextApi {

    companion object {

        private var applicationContextComponent: ApplicationContextComponent? = null

        fun initAndGet(dependencies: ApplicationContextDependencies): ApplicationContextComponent {
            if (applicationContextComponent == null) {
                Log.d("AppTag", "ApplicationContextComponent init")
                synchronized(ApplicationContextComponent::class.java) {
                    if (applicationContextComponent == null) {
                        applicationContextComponent = DaggerApplicationContextComponent.factory()
                            .create(dependencies)
                    }
                }
            }
            return applicationContextComponent!!
        }
    }

    @Component.Factory
    interface Factory {
        fun create(dependencies: ApplicationContextDependencies): ApplicationContextComponent
    }
}