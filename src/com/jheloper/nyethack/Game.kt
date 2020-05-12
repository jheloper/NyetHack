package com.jheloper.nyethack

// 파일 수준 변수
const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    // 지역 변수
    // var healthPoints = 89
    // val isBlessed = true
    // val isImmortal = false
    // val race = "gnome"

    val player = Player("madrigal")
    // val player2 = Player("")
    // player.name = "estragon "
    // println(player.name + "TheBrave")

    player.castFireBall()

    var currentRoom = Room("Foyer")
    println(currentRoom.description())
    println(currentRoom.load())

    // 지명 함수 인자를 사용하여 원하는 순서로 인자를 전달할 수 있다.
    printPlayerStatus(player)

    performCombat()
    performCombat("Ulrich")
    performCombat("Hildr", true)
    `**~prolly not a good idea!~**`()

    val myDice = Dice()
    println(myDice.rolledValue)
    println(myDice.rolledValue)
    println(myDice.rolledValue)
}

private fun printPlayerStatus(
    player: Player
) {
    println("${player.name} faction is ${player.faction()}")
    println("(HP: ${player.healthPoints})(Aura: ${player.auraColor()})(Blessed: ${if (player.isBlessed) "YES" else "NO"}) -> ${player.name} ${player.formatHealthStatus()}")
}

// 단일 표현식 함수. 함수 몸체를 사용하는 대신 대입 연산자 다음에 표현식(실행 코드) 정의.
//private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
//    100 -> "best condition!"
//    in 90..99 -> "some scratch."
//    in 75..89 -> if (isBlessed) {
//        "slight wound, but heal quickly."
//    } else {
//        "slight wound."
//    }
//    in 15..74 -> "hurt a lot."
//    else -> "worst condition!"
//}

// 아무것도 반환하지 않는 함수는 Unit 반환 함수.
//private fun castFireBall(numFireBalls: Int = 2) = println("shoot fire ball. (x$numFireBalls)")

// Nothing 타입을 반환하는 경우 제어권이 복귀되지 않음.
private fun shouldReturnAString(): String {
    // TODO() 함수는 Nothing 타입을 반환.
    TODO("문자열을 반환하는 코드를 여기에 구현해야 함")
    println("이 코드는 실행되지 않음")
}

fun performCombat() {
    println("No enemy!")
}

fun performCombat(enemyName: String) {
    println("combat $enemyName.")
}

fun performCombat(enemyName: String, isBlessed: Boolean) {
    if (isBlessed) {
        println("start combat $enemyName. blessed!")
    } else {
        println("start combat $enemyName.")
    }
}

fun `**~prolly not a good idea!~**`() {
    println("this function has backtick function name")
}