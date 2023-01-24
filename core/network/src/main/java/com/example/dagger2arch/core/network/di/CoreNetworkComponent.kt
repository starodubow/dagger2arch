package com.example.dagger2arch.core.network.di

import com.example.dagger2arch.core.network.di.external.CoreNetworkApi
import com.example.dagger2arch.core.network.di.external.CoreNetworkDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreNetworkModule::class],
    dependencies = [CoreNetworkDependencies::class]
)
abstract class CoreNetworkComponent : CoreNetworkApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: CoreNetworkDependencies): CoreNetworkComponent
    }
}