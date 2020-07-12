package com.jheloper.nyethack

enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
        Coordinate(playerCoordinate.x + coordinate.x, playerCoordinate.y + coordinate.y)
}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}

fun main(args: Array<String>) {
    val coordinate = Coordinate(1, 2)
    println(coordinate)

    println(coordinate == Coordinate(1, 2))

    println(coordinate.copy(x = 3))

    val (x, y) = coordinate
    println("x is $x, y is $y")

    println(Direction.EAST.updateCoordinate(Coordinate(1, 0)))
}