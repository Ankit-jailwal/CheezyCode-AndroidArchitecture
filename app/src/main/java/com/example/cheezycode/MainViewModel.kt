package com.example.cheezycode

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context: Context) : ViewModel() {
     private var quoteList: Array<Quote> = emptyArray()
     private var index = 0

    init {
        quoteList = loadQuoteList()
    }

    private fun loadQuoteList() : Array<Quote> {
        // To open the json file we create input stream
        val inputStream = context.assets.open("quotes.json")

        // We get size of input stream
        val size: Int = inputStream.available()

        // Buffer space to store the file
        val buffer = ByteArray(size)

        // We store all the data from stream in buffer
        inputStream.read(buffer)

        // Then we close the stream
        inputStream.close()

        // Convert buffer array to String
        val json = String(buffer, Charsets.UTF_8)

        // Create gson object for parsing
        val gson = Gson()

        // Convert json to java object
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index]

    fun previousQuote() = quoteList[--index]
}