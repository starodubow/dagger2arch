package com.example.dagger2arch.core.data.di

import android.content.Context

interface CoreDataDependencies {

    fun provideApplicationContext(): Context
}