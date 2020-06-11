package com.jheloper.nyethack

class Dice {
    val rolledValue
        get() = (1..6).shuffled().first()
}

fun main(args: Array<String>) {
    val myDice = Dice()
    println(myDice.rolledValue)
    println(myDice.rolledValue)
    println(myDice.rolledValue)
}