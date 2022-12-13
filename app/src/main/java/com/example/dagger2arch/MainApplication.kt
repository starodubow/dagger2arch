package com.example.dagger2arch

import android.app.Application
import android.util.Log
import com.example.dagger2arch.core.base_di.FeatureComponent
import com.example.dagger2arch.core.base_di.FeatureComponentMap
import com.example.dagger2arch.core.base_di.FeatureComponentProvider
import com.example.dagger2arch.di.AppComponent
import com.example.dagger2arch.di.DaggerAppComponent
import javax.inject.Inject
import kotlin.reflect.KClass
import kotlin.reflect.cast

class MainApplication : Application(), FeatureComponentProvider {

    lateinit var appComponent: AppComponent
    @Inject
    lateinit var componentsMap: FeatureComponentMap

    override fun onCreate() {
        super.onCreate()
        Log.d("AppTag", "MainApplication onCreate")

        // Создаём компонент уровня приложения
        appComponent = DaggerAppComponent.factory().create(this)
        appComponent.inject(this)
    }

    override fun <T : FeatureComponent> getFeatureComponent(klass: KClass<T>): T {
        val component =  componentsMap[klass.java]!!.get()
        if (component == null || !klass.isInstance(component)) {
            throw RuntimeException("Component $klass should be added @IntoMap @FeatureComponentClassKey")
        }
        return klass.cast(component)
    }
}