package com.example.dagger2arch.core.network.di

import android.content.Context
import com.example.dagger2arch.core.data.data.UserData
import javax.inject.Inject

class CoreNetworkDependencies @Inject constructor(
    val applicationContext: Context,
    val userData: UserData
)