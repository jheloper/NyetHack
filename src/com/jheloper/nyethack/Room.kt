package com.jheloper.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Room: $name" + System.lineSeparator() + "Danger Level: $dangerLevel"

    open fun load() = "No one came here..."
}

class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "Dang!!"

    override fun load() = "All residents welcome your join."

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}