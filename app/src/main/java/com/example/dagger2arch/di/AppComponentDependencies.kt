package com.example.dagger2arch.di

import com.example.dagger2arch.core.data.data.UserData

interface AppComponentDependencies {

    fun provideUserData(): UserData
}