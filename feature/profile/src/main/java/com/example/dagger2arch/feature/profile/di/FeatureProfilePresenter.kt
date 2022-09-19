package com.example.dagger2arch.feature.profile.di

import com.example.dagger2arch.core.data.UserData
import retrofit2.Retrofit

class FeatureProfilePresenter(val userData: UserData, val builder: Retrofit.Builder)