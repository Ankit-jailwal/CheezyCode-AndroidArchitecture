package com.example.cheezycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txtCounter : TextView
    lateinit var button : Button

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = androidx.lifecycle.ViewModelProvider(this).get(MainViewModel::class.java)
        val observer = Observer()
        lifecycle.addObserver(observer)
        txtCounter = findViewById(R.id.count)
        button = findViewById(R.id.button)
        setCount()
    }



    fun setCount() {
        txtCounter.text = mainViewModel.count.toString()

    }

    fun increment (v: View) {
        mainViewModel.increment()
        setCount()
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