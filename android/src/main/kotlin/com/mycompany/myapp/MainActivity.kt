package com.mycompany.myapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import nl.komponents.kovenant.then

val url = "http://web.invaluable.com/app/online-auctions"

class MainActivity : Activity() {
    private val counterStore = CounterStore()
    private val fuelService = FuelHttpService()
    private val searchParser = AuctionSearchJsonParser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        val counterTextView = findViewById(R.id.counterTextView) as TextView
        val counterButton = findViewById(R.id.counterButton) as Button

        // returns a promise
        val resultPromise = fuelService.textUrl(url)

        // parse the results and display them
        var auctions = resultPromise.then { msg ->
            searchParser.parse(msg)
        }.get().auctions

        counterButton.setOnClickListener { view ->
            counterTextView.text = auctions[counterStore.get()].name
            counterStore.add(1)
        }

    }
}
