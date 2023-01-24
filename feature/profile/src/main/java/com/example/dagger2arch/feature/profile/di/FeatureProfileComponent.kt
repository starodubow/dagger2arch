package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.common.CoreDependenciesMapProvider
import com.example.dagger2arch.feature.profile.FeatureProfileActivity
import dagger.Component

@Component(
    modules = [
        FeatureProfileModule::class,
        FeatureProfileDependenciesModule::class
    ],
    dependencies = [CoreDependenciesMapProvider::class]
)
interface FeatureProfileComponent {

    fun inject(activity: FeatureProfileActivity)

    @Component.Factory
    interface Factory {
        fun create(mapProvider: CoreDependenciesMapProvider): FeatureProfileComponent
    }
}