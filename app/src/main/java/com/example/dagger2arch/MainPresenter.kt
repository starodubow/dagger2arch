package com.example.dagger2arch

import com.example.dagger2arch.core.data.UserData

class MainPresenter(private val userData: UserData) {
    fun printUserDataX() {
        userData.printX()
    }
}