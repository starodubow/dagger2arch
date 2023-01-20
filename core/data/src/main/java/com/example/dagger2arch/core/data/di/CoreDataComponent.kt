package com.example.dagger2arch.core.data.di

import com.example.dagger2arch.core.data.di.external.CoreDataApi
import com.example.dagger2arch.core.data.di.external.CoreDataDependencies
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreDataModule::class],
    dependencies = [
        CoreDataDependencies::class
    ]
)
abstract class CoreDataComponent : CoreDataApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: CoreDataDependencies): CoreDataComponent
    }
}