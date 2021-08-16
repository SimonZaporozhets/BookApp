package com.books.app.loading

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.books.app.App
import com.books.app.HostActivity
import com.books.app.databinding.ActivitySplashBinding
import com.books.app.model.RemoteConfigUseCase
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var remoteConfigUseCase: RemoteConfigUseCase

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, HostActivity::class.java)

        App.appComponent.inject(this)

        remoteConfigUseCase.invoke()

        var t = 0
        val handler = Handler(mainLooper)
        handler.postDelayed(object : Runnable {
            override fun run() {
                t++
                binding.indeterminateBar.progress = t
                if (t < 100) {
                    handler.postDelayed(this, 20);
                } else {
                    startActivity(intent)
                    finish()
                }
            }
        }, TimeUnit.SECONDS.toMillis(2))
    }
}