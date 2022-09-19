package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.data.UserData
import com.example.dagger2arch.core.data.di.CoreDataApi
import com.example.dagger2arch.core.network.di.CoreNetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class FeatureProfileModule {

    @Provides
    fun provideFeatureProfilePresenter(
        userData: UserData,
        builder: Retrofit.Builder
    ): FeatureProfilePresenter {
        return FeatureProfilePresenter(userData, builder)
    }
}