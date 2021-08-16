package com.books.app.di

import android.content.Context
import com.books.app.details.DetailsFragment
import com.books.app.HostActivity
import com.books.app.library.LibraryFragment
import com.books.app.loading.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun applicationContext(): Context

    fun inject(hostActivity: HostActivity)

    fun inject(splashActivity: SplashActivity)

    fun inject(fragment: LibraryFragment)

    fun inject(fragment: DetailsFragment)

}