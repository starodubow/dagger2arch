package com.example.dagger2arch.core.data.di

import android.content.Context
import com.example.dagger2arch.core.data.data.UserData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class CoreDataModule {

    @Singleton
    @Provides
    fun provideUserData(applicationContext: Context): UserData {
        return UserData(applicationContext)
    }
}