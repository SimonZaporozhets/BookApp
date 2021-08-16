package com.books.app

import android.app.Application
import com.books.app.di.AppComponent
import com.books.app.di.AppModule
import com.books.app.di.DaggerAppComponent
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupDi()
        initFirebase()
    }

    private fun setupDi() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(
                AppModule(this)
            )
            .build()
    }

    private fun initFirebase() {
        FirebaseRemoteConfig.getInstance()
            .setConfigSettingsAsync(FirebaseRemoteConfigSettings.Builder().build())
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}