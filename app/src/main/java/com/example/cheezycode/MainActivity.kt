package com.example.cheezycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val observer = Observer()
        lifecycle.addObserver(observer)
        Log.d("main", "Main activity oncreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("main", "Main activity onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("main", "Main activity onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("main", "Main activity onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("main", "Main activity onDestroy")
    }
}