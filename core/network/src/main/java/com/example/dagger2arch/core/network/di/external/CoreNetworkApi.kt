package com.example.dagger2arch.core.network.di.external

import com.example.dagger2arch.core.common.CoreDependenciesApi
import com.example.dagger2arch.core.network.data.BaseApiRouter
import retrofit2.Retrofit

interface CoreNetworkApi : CoreDependenciesApi
 {

    fun provideBaseApiRouter(): BaseApiRouter

    fun provideRetrofitBuilder(): Retrofit.Builder
}