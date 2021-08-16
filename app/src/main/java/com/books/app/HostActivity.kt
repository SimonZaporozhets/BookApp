package com.books.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.books.app.di.AppComponent
import javax.inject.Inject

class HostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.host_activity)

        App.appComponent.inject(this)
    }

}