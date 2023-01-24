package com.example.dagger2arch.di

import com.example.dagger2arch.core.common.CoreDependenciesApi
import com.example.dagger2arch.core.data.CoreDataProvider
import com.example.dagger2arch.core.data.di.external.CoreDataApi
import com.example.dagger2arch.core.network.CoreNetworkProvider
import com.example.dagger2arch.core.network.di.external.CoreNetworkApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
class CoreDependenciesModule {

    @Singleton
    @Provides
    @IntoMap
    @ClassKey(CoreNetworkApi::class)
    fun provideCoreNetworkApi(depsProvider: AppComponent): CoreDependenciesApi {
        return CoreNetworkProvider.getCoreNetworkApi(
            dependencies = depsProvider
        )
    }

    @Singleton
    @Provides
    @IntoMap
    @ClassKey(CoreDataApi::class)
    fun provideCoreDataApi(depsProvider: AppComponent): CoreDependenciesApi {
        return CoreDataProvider.provideCoreDataApi(
            dependencies = depsProvider
        )
    }
}