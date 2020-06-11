package com.jheloper.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Room: $name" + System.lineSeparator() + "Danger Level: $dangerLevel"

    open fun load() = "No one came here..."
}

open class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "Dang!!"

    // TownSquare의 서브클래스는 load 메서드를 override할 수 없다.
    final override fun load() = "All residents welcome your join.\r\n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}

fun main(args: Array<String>) {
    val currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    println("Room type is: ${checkRoomType(currentRoom)}")

    val sourceOfBlessingsRoom = Room("Fount of Blessings")

    printIsSourceOfBlessings(sourceOfBlessingsRoom)
}