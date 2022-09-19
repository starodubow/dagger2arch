package com.example.dagger2arch.core.network.di

import com.example.dagger2arch.core.network.data.BaseApiRouter
import retrofit2.Retrofit

interface CoreNetworkApi {

    fun provideBaseApiRouter(): BaseApiRouter

    fun provideRetrofitBuilder(): Retrofit.Builder
}