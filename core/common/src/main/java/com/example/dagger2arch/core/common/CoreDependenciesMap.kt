package com.example.dagger2arch.core.common

import javax.inject.Provider

typealias CoreDependenciesMap = Map<Class<*>, @JvmSuppressWildcards Provider<CoreDependenciesApi>>

inline fun <reified T : CoreDependenciesApi> CoreDependenciesMap.getDependency(): T {
    return getValue(T::class.java).get() as T
}