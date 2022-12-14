package com.example.dagger2arch.feature.profile.di.internal

import com.example.dagger2arch.feature.profile.FeatureProfileActivity
import com.example.dagger2arch.feature.profile.di.FeatureProfileDependencies
import com.example.dagger2arch.core.base_di.FeatureComponent
import dagger.Component

@Component(
    modules = [FeatureProfileModule::class],
    dependencies = [FeatureProfileDependencies::class]
)
internal interface FeatureProfileComponent : FeatureComponent {

    fun inject(activity: FeatureProfileActivity)

    @Component.Factory
    interface Factory {
        fun create(dependencies: FeatureProfileDependencies): FeatureProfileComponent
    }
}