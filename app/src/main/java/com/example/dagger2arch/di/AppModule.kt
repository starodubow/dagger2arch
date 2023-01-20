package com.example.dagger2arch.di

import android.content.Context
import com.example.dagger2arch.MainApplication
import com.example.dagger2arch.MainPresenter
import com.example.dagger2arch.core.common.CoreDependenciesMap
import com.example.dagger2arch.core.common.getDependency
import com.example.dagger2arch.core.data.data.UserData
import com.example.dagger2arch.core.data.di.external.CoreDataApi
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
    fun provideUserData(map: CoreDependenciesMap): UserData =
        map.getDependency<CoreDataApi>().provideUserData()

    @Provides
    fun providePresenter(userData: UserData): MainPresenter {
        return MainPresenter(userData)
    }
}