package com.jheloper.init

class Player(_name: String, val health: Int) { // health가 1번째
    // race, town, name이 2번째
    val race = "DWARF"
    var town = "Bavaria"
    val name = _name

    val alignment: String
    private var age = 0

    init {
        // init 블럭이 3번째
        println("initializing player")
        alignment = "GOOD"
    }

    constructor(_name: String) : this(_name, 100) {
        // 보조 생성자가 4번째
        town = "The Shire"
    }
}

fun main(args: Array<String>) {
    Player("Madrigal")
}