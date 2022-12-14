package com.example.dagger2arch.core.base_di

import kotlin.reflect.KClass

interface FeatureComponentProvider {
    fun <T : FeatureComponent> getFeatureComponent(klass: KClass<T>): T
}