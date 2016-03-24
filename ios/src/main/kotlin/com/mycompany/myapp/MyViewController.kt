package com.mycompany.myapp

import nl.komponents.kovenant.then
import org.robovm.apple.uikit.UILabel
import org.robovm.apple.uikit.UIViewController
import org.robovm.objc.annotation.CustomClass
import org.robovm.objc.annotation.IBAction
import org.robovm.objc.annotation.IBOutlet

val url = "http://web.invaluable.com/app/online-auctions"

@CustomClass("MyViewController")
class MyViewController : UIViewController() {
    private val counterStore = CounterStore()
    //    private val fuelService = FuelHttpService()
    //    private val searchParser = AuctionSearchJsonParser()
    //    private var auctions: List<Auction>? = null;

    @IBOutlet
    private val label: UILabel? = null

    override fun viewWillAppear(p0: Boolean) {
        super.viewWillAppear(p0)
        // returns a promise
        //        val resultPromise = fuelService.textUrl(url)
        //
        //        // parse the results and display them
        //        var auctions = resultPromise.then { msg ->
        //            searchParser.parse(msg)
        //        }.get().auctions
    }

    @IBAction
    private fun clicked() {
        counterStore.add(1)
        label!!.text = "Click Nr. " + counterStore.get()
        //        label!!.text = auctions?.get(counterStore.get())?.name
    }
}

