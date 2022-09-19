package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.data.UserData
import retrofit2.Retrofit

interface FeatureProfileDependencies {
    fun provideRetrofitBuilder(): Retrofit.Builder

    fun provideUserData(): UserData
}