package com.example.app_api.external

import android.content.Context

interface ApplicationContextApi {
    fun provideApplicationContext(): Context
}