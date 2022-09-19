package com.example.dagger2arch.core.network.di

import android.content.Context
import com.example.dagger2arch.core.data.UserData

interface CoreNetworkDependencies {

    fun provideApplicationContext(): Context

    fun provideUserData(): UserData

}