package com.example.dagger2arch.core.network.di.internal

import com.example.dagger2arch.core.network.di.CoreNetworkApi
import com.example.dagger2arch.core.network.di.CoreNetworkDependencies
import com.example.dagger2arch.core.base_di.FeatureComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreNetworkModule::class],
    dependencies = [CoreNetworkDependencies::class]
)
internal abstract class CoreNetworkComponent : CoreNetworkApi, FeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: CoreNetworkDependencies): CoreNetworkComponent
    }
}