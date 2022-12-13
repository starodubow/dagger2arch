package com.example.dagger2arch

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2arch.di.getAppComponent
import com.example.dagger2arch.feature.profile.FeatureProfileActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AppTag", "MainActivity onCreate")
        getAppComponent().inject(this)

        Toast.makeText(this, this::class.java.toString(), Toast.LENGTH_SHORT).show()

        presenter.printUserDataX()

        Handler().postDelayed({
            startActivity(Intent(this, FeatureProfileActivity::class.java))
        }, 5_000)

    }
}