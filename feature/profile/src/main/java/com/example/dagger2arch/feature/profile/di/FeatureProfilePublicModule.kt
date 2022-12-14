package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.base_di.FeatureComponent
import com.example.dagger2arch.feature.profile.di.internal.DaggerFeatureProfileComponent
import com.example.dagger2arch.feature.profile.di.internal.FeatureProfileComponent
import com.example.dagger2arch.core.base_di.FeatureComponentClassKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

// Модуль-связка между внутренним компонентом и внешним комопонентом dagger.
@Module
class FeatureProfilePublicModule {

    // Складываем внутренний компонент в общую мапу для всех компонентов
    @Provides
    @IntoMap
    @FeatureComponentClassKey(FeatureProfileComponent::class)
    internal fun provideFeatureProfileComponent(deps: FeatureProfileDependencies): FeatureComponent =
        DaggerFeatureProfileComponent.factory().create(deps)
}