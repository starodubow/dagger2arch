package com.example.dagger2arch.feature.profile

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2arch.core.data.UserData
import com.example.dagger2arch.core.data.di.CoreDataComponent
import com.example.dagger2arch.core.network.di.CoreNetworkComponent
import com.example.dagger2arch.feature.profile.di.DaggerFeatureProfileComponent
import com.example.dagger2arch.feature.profile.di.FeatureProfileDependencies
import com.example.dagger2arch.feature.profile.di.FeatureProfilePresenter
import retrofit2.Retrofit
import javax.inject.Inject

class FeatureProfileActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: FeatureProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AppTag", "FeatureProfileActivity onCreate")
        DaggerFeatureProfileComponent
            .factory()
            .create(dependencies = object : FeatureProfileDependencies {
                override fun provideRetrofitBuilder(): Retrofit.Builder {
                    return CoreNetworkComponent.get().provideRetrofitBuilder()
                }

                override fun provideUserData(): UserData {
                    return CoreDataComponent.get().provideUserData()
                }
            })
            .inject(this)

        Toast.makeText(this, this::class.java.toString(), Toast.LENGTH_SHORT).show()

        presenter.userData.printX()

    }
}