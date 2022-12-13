package com.example.dagger2arch.core.data.di

import android.content.Context
import javax.inject.Inject

class CoreDataDependencies @Inject constructor(
    val applicationContext: Context
)