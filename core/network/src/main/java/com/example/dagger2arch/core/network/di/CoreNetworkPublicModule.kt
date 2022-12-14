package com.example.dagger2arch.core.network.di

import com.example.dagger2arch.core.base_di.FeatureComponent
import com.example.dagger2arch.core.base_di.FeatureComponentClassKey
import com.example.dagger2arch.core.network.di.internal.CoreNetworkComponent
import com.example.dagger2arch.core.network.di.internal.DaggerCoreNetworkComponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton


// Модуль-связка между внутренним компонентом и внешним комопонентом dagger. Получается
// достаточно много непонятного бойлерплейта внутри, но снаружи подключается легко. Бойлерплейт
// типовой и можно попробовать убрать его через кодогенерацию. Единственное решение, которое
// тут принимает разработчик - какой скоуп указать для компонента.
@Module
abstract class CoreNetworkPublicModule {

    companion object {
        // Создаём компонент и сохраняем его в родительском графе. Тут нужно указать правильный
        // скоуп. Получается, что *PublicModule знает куда он будет подключаться. Теоретически можно
        // использовать 1 скоуп для всего, если не использовать сабкомпоненты
        @Provides
        @Singleton
        internal fun provideCoreDataApi(deps: CoreNetworkDependencies): CoreNetworkComponent =
            DaggerCoreNetworkComponent.factory().create(deps)

        // Выкидываем каждую отдельную зависимость из апи в родительский граф
        @Provides
        fun provideRetrofitBuilder(api: CoreNetworkApi) = api.provideRetrofitBuilder()
        @Provides
        fun provideBaseApiRouter(api: CoreNetworkApi) = api.provideBaseApiRouter()
    }

    // Выкидываем публичное апи в родительский граф
    @Binds
    internal abstract fun bindCoreNetworkApi(component: CoreNetworkComponent): CoreNetworkApi

    // Складываем внутренний компонент в общую мапу для всех компонентов
    @Binds
    @IntoMap
    @FeatureComponentClassKey(CoreNetworkComponent::class)
    internal abstract fun bindApplicationContextComponent(component: CoreNetworkComponent): FeatureComponent
}
