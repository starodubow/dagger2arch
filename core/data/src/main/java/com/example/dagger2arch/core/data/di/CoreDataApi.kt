package com.example.dagger2arch.core.data.di

import com.example.dagger2arch.core.data.data.UserData

interface CoreDataApi {
    fun provideUserData(): UserData
}