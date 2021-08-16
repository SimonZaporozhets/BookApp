package com.books.app.model

import com.books.app.model.RemoteConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteConfigRepository @Inject constructor() {

    private lateinit var remoteConfig: RemoteConfig

    val config: RemoteConfig
        get() = remoteConfig

    fun updateConfig(remoteConfig: RemoteConfig) {
        this.remoteConfig = remoteConfig
    }

}