package com.example.app_api.di

import android.content.Context

interface ApplicationContextDependencies {
    fun provideApplicationContext(): Context
}