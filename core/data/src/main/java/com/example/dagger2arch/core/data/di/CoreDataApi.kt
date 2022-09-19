package com.example.dagger2arch.core.data.di

import android.content.Context
import com.example.dagger2arch.core.data.data.UserData

interface CoreDataApi {
    fun provideUserData(): UserData

    fun proxyProvideApplicationContext(): Context
}