package com.example.dagger2arch.di

import com.example.dagger2arch.MainPresenter
import com.example.dagger2arch.core.data.data.UserData
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {

    @Provides
    fun providePresenter(userData: UserData): MainPresenter {
        return MainPresenter(userData)
    }
}