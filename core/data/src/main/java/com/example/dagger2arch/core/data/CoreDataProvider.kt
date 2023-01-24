package com.example.dagger2arch.core.data

import com.example.dagger2arch.core.data.di.DaggerCoreDataComponent
import com.example.dagger2arch.core.data.di.external.CoreDataApi
import com.example.dagger2arch.core.data.di.external.CoreDataDependencies

object CoreDataProvider {

    fun provideCoreDataApi(dependencies: CoreDataDependencies): CoreDataApi =
        DaggerCoreDataComponent.factory().create(dependencies)
}