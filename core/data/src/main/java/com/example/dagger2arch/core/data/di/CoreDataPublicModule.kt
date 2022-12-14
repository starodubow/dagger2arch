package com.example.dagger2arch.core.data.di

import com.example.dagger2arch.core.base_di.FeatureComponent
import com.example.dagger2arch.core.base_di.FeatureComponentClassKey
import com.example.dagger2arch.core.data.di.internal.CoreDataComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.example.dagger2arch.core.data.di.internal.DaggerCoreDataComponent
import dagger.Binds
import dagger.multibindings.IntoMap

// Модуль-связка между внутренним компонентом и внешним комопонентом dagger. Получается
// достаточно много непонятного бойлерплейта внутри, но снаружи подключается легко. Бойлерплейт
// типовой и можно попробовать убрать его через кодогенерацию. Единственное решение, которое
// тут принимает разработчик - какой скоуп указать для компонента.
@Module
abstract class CoreDataPublicModule {

    companion object {
        // Создаём компонент и сохраняем его в родительском графе. Тут нужно указать правильный
        // скоуп. Получается, что *PublicModule знает куда он будет подключаться. Теоретически можно
        // использовать 1 скоуп для всего, если не использовать сабкомпоненты
        @Provides
        @Singleton
        internal fun provideCoreDataApi(deps: CoreDataDependencies): CoreDataComponent =
            DaggerCoreDataComponent.factory().create(deps)

        // Выкидываем каждую отдельную зависимость из апи в родительский граф
        @Provides
        fun providesUserData(api: CoreDataApi) = api.provideUserData()
    }

    // Выкидываем публичное апи в родительский граф
    @Binds
    internal abstract fun bindCoreDataApi(component: CoreDataComponent): CoreDataApi

    // Складываем внутренний компонент в общую мапу для всех компонентов
    @Binds
    @IntoMap
    @FeatureComponentClassKey(CoreDataComponent::class)
    internal abstract fun bindApplicationContextComponent(component: CoreDataComponent): FeatureComponent
}