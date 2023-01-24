package com.example.dagger2arch.core.data.data

import android.content.Context
import android.util.Log
import kotlin.random.Random

data class UserData(val applicationContext: Context) {

    private val x: Int by lazy {
        Random.nextInt(0,10000)
    }

    fun printX() {
        Log.d("AppTag", "x = $x")
    }
}