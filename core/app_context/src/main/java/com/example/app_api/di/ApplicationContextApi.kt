package com.example.app_api.di

import android.content.Context

interface ApplicationContextApi {
    fun provideApplicationContext(): Context
}