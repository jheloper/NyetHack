package com.jheloper.init

class Wheel {
    // 지연 초기화 속성
    lateinit var alignment: String

    fun initAlignment() {
        alignment = "Good"
    }

    fun printAlignment() {
        if (::alignment.isInitialized) {
            println(alignment)
        }
    }
}

fun main(args: Array<String>) {
    var wheel = Wheel()
    wheel.initAlignment()
    wheel.printAlignment()
}