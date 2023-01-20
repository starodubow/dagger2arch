package com.example.dagger2arch.core.network

import com.example.dagger2arch.core.network.di.DaggerCoreNetworkComponent
import com.example.dagger2arch.core.network.di.external.CoreNetworkApi
import com.example.dagger2arch.core.network.di.external.CoreNetworkDependencies

object NetworkApi {

    fun getCoreNetworkApi(dependencies: CoreNetworkDependencies): CoreNetworkApi =
        DaggerCoreNetworkComponent
            .factory()
            .create(dependencies)
}