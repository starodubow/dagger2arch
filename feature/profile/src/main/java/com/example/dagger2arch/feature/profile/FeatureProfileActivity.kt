package com.example.dagger2arch.feature.profile

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2arch.feature.profile.di.internal.FeatureProfileComponent
import com.example.dagger2arch.core.base_di.getFeatureComponent
import javax.inject.Inject

class FeatureProfileActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: FeatureProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AppTag", "FeatureProfileActivity onCreate")
        val component = getFeatureComponent<FeatureProfileComponent>()
        component.inject(this)

        Toast.makeText(this, this::class.java.toString(), Toast.LENGTH_SHORT).show()

        presenter.userData.printX()

    }
}