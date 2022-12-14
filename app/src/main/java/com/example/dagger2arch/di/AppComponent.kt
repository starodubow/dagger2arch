package com.example.dagger2arch.di

import android.content.Context
import com.example.dagger2arch.MainActivity
import com.example.dagger2arch.MainApplication
import com.example.dagger2arch.core.data.di.CoreDataPublicModule
import com.example.dagger2arch.core.network.di.CoreNetworkPublicModule
import com.example.dagger2arch.feature.profile.di.FeatureProfilePublicModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        // Добавляем сюда PublicModule'и всех фичей. Больше ничего для связывания не нужно
        CoreDataPublicModule::class,
        CoreNetworkPublicModule::class,
        FeatureProfilePublicModule::class
    ]
)
abstract class AppComponent {

    abstract fun inject(application: MainApplication)
    abstract fun inject(activity: MainActivity)


    @Component.Factory
    interface Factory {

        fun create(@BindsInstance applicationContext: Context): AppComponent

    }

}
