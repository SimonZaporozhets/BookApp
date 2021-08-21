package com.books.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.host_activity)

        App.appComponent.inject(this)
    }

}