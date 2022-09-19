package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.feature.profile.FeatureProfileActivity
import dagger.Component

@Component(
    modules = [FeatureProfileModule::class],
    dependencies = [FeatureProfileDependencies::class]
)
interface FeatureProfileComponent {

    fun inject(activity: FeatureProfileActivity)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FeatureProfileDependencies): FeatureProfileComponent
    }
}