package com.example.dagger2arch.core.base_di

import android.app.Activity
import android.app.Application

inline fun <reified T : FeatureComponent> Activity.getFeatureComponent(): T {
    return application.getFeatureComponent()
}

inline fun <reified T : FeatureComponent> Application.getFeatureComponent(): T {
    if (this !is FeatureComponentProvider) {
        throw ComponentProviderNotImplementedException()
    }
    return this.getFeatureComponent(T::class)
}

class ComponentProviderNotImplementedException :
    RuntimeException("Application must implement interface FeatureComponentProvider")



