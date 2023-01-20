package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.common.CoreDependenciesMap
import com.example.dagger2arch.core.common.getDependency
import com.example.dagger2arch.core.data.data.UserData
import com.example.dagger2arch.core.data.di.external.CoreDataApi
import com.example.dagger2arch.core.network.di.external.CoreNetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class FeatureProfileDependenciesModule {

    @Provides
    fun provideRetrofitBuilder(map: CoreDependenciesMap): Retrofit.Builder =
        map.getDependency<CoreNetworkApi>().provideRetrofitBuilder()


    @Provides
    fun provideUserData(map: CoreDependenciesMap): UserData =
        map.getDependency<CoreDataApi>().provideUserData()
}