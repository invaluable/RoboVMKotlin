package com.mycompany.myapp

class CounterStore {
    private var count: Int = 0

    fun add(num: Int) {
        count += num
    }

    fun get(): Int {
        return count
    }
}
