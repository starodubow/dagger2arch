package com.example.app_api.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [ApplicationContextDependencies::class])
internal abstract class ApplicationContextComponent : ApplicationContextApi {

    companion object {

        fun initAndGet(dependencies: ApplicationContextDependencies): ApplicationContextComponent {
            return DaggerApplicationContextComponent
                .factory()
                .create(dependencies)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(dependencies: ApplicationContextDependencies): ApplicationContextComponent
    }
}