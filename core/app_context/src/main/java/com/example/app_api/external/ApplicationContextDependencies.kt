package com.example.app_api.external

import android.content.Context

interface ApplicationContextDependencies {
    fun provideApplicationContext(): Context
}