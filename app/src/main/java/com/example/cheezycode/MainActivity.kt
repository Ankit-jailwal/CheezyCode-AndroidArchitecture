package com.example.cheezycode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val quoteText : TextView
        get() = findViewById(R.id.heading)

    private val author : TextView
        get() = findViewById(R.id.subheading)

    private val prevButton : TextView
        get() = findViewById(R.id.prev)

    private val nextButton : TextView
        get() = findViewById(R.id.next)

    private val shareButton : FloatingActionButton
        get() = findViewById(R.id.share)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // LIFECYCLE OBSERVER
        val observer = Observer()
        lifecycle.addObserver(observer)

        // Declaring viewmodel
        mainViewModel = androidx.lifecycle.ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)

        setQuote(mainViewModel.getQuote())

        prevButton.setOnClickListener {
            onPrevious()
        }

        nextButton.setOnClickListener {
            onNext()
        }

        shareButton.setOnClickListener {
            onShare()
        }

    }

    fun setQuote(quote: Quote) {
        quoteText.text = quote.text
        author.text = quote.author
    }

    fun onPrevious() = setQuote(mainViewModel.previousQuote())
    fun onNext() = setQuote(mainViewModel.nextQuote())
    fun onShare() {
        val intent = Intent(Intent.ACTION_SEND)

        intent.setType("text/plain")

        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)

        startActivity(intent)
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