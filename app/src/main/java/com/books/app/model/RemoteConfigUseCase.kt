package com.books.app.model

import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.gson.GsonBuilder
import javax.inject.Inject


class RemoteConfigUseCase @Inject constructor(private val remoteConfigRepository: RemoteConfigRepository) {

    private val firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    fun invoke() {
        firebaseRemoteConfig.fetch(3600)
            .addOnSuccessListener {
                firebaseRemoteConfig.activate().addOnCompleteListener {
                    remoteConfigRepository.updateConfig(provideRemoteConfig())
                }
            }
            .addOnFailureListener {
                Log.i("firebaseError", "invoke: $it")
            }
    }

    private fun provideRemoteConfig(): RemoteConfig {
        val result = firebaseRemoteConfig.getString(KEY)
        val gson = GsonBuilder().create()
        return gson.fromJson(result, RemoteConfig::class.java)
    }

    companion object {
        private const val KEY = "json_data"
    }
}