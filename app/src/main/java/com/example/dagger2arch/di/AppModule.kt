package com.example.dagger2arch.di

import android.content.Context
import com.example.dagger2arch.MainApplication
import com.example.dagger2arch.MainPresenter
import com.example.dagger2arch.core.data.data.UserData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return MainApplication.appContext
    }

    @Provides
    fun providePresenter(userData: UserData): MainPresenter {
        return MainPresenter(userData)
    }
}