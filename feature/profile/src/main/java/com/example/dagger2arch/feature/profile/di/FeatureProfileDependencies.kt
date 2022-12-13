package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.data.data.UserData
import retrofit2.Retrofit
import javax.inject.Inject

class FeatureProfileDependencies @Inject constructor(
    val retrofitBuilder: Retrofit.Builder,
    val userData: UserData
)