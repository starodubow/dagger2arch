package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.data.data.UserData
import com.example.dagger2arch.feature.profile.FeatureProfilePresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

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