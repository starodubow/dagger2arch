package com.example.dagger2arch.core.data.di.external

import com.example.dagger2arch.core.common.CoreDependenciesApi
import com.example.dagger2arch.core.data.data.UserData

interface CoreDataApi : CoreDependenciesApi {
    fun provideUserData(): UserData
}