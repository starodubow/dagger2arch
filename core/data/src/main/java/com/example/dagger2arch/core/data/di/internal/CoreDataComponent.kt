package com.example.dagger2arch.core.data.di.internal

import com.example.dagger2arch.core.data.di.CoreDataApi
import com.example.dagger2arch.core.data.di.CoreDataDependencies
import com.example.dagger2arch.core.base_di.FeatureComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreDataModule::class],
    dependencies = [
        CoreDataDependencies::class
    ]
)
internal abstract class CoreDataComponent : CoreDataApi, FeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: CoreDataDependencies): CoreDataComponent
    }
}