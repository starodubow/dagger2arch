package com.example.dagger2arch.core.base_di

import javax.inject.Provider

typealias FeatureComponentMap = Map<Class<out FeatureComponent>, @JvmSuppressWildcards Provider<FeatureComponent>>