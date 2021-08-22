package com.books.app

import android.os.Handler
import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.autoScroll(interval: Long) {

    val handler = Handler()
    var scrollPosition = 0

    val runnable = object : Runnable {

        override fun run() {
            val count = adapter?.itemCount ?: 0
            setCurrentItem(scrollPosition++ % count, true)

            handler.postDelayed(this, interval)
        }
    }

    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            scrollPosition = position + 1
        }
    })

    handler.post(runnable)
}