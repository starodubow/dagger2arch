package com.example.dagger2arch.di

import android.app.Activity
import com.example.dagger2arch.MainApplication

fun Activity.getAppComponent(): AppComponent {
    return (application as MainApplication).appComponent
}