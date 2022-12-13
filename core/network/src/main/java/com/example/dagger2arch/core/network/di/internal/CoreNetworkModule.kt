package com.example.dagger2arch.core.network.di.internal

import android.content.Context
import com.example.dagger2arch.core.network.data.BaseApiRouter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
internal class CoreNetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    @Singleton
    @Provides
    fun provideBaseApiRouter(applicationContext: Context): BaseApiRouter {
        return BaseApiRouter(applicationContext)
    }

}