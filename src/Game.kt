/**
 * @author joonghyeon.kim
 */
// 파일 수준 변수
const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    // 지역 변수
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val race = "gnome"

    // faction
    val faction = faction(race)

    // aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(healthPoints, auraColor, isBlessed, name, healthStatus, faction)
}

private fun faction(race: String): String {
    return when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "No faction"
    }
}

private fun printPlayerStatus(
    healthPoints: Int,
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String,
    faction: String
) {
    println("$name faction is $faction")
    println("(HP: $healthPoints)(Aura: $auraColor)(Blessed: ${if (isBlessed) "YES" else "NO"}) -> $name $healthStatus")
    castFireBall()
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraInvisible = isBlessed && healthPoints > 50 || isImmortal
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    val auraColor = if (auraInvisible) {
        when (karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purple"
            in 16..20 -> "green"
            else -> "none"
        }
    } else {
        "none"
    }
    return auraColor
}

// 단일 표현식 함수. 함수 몸체를 사용하는 대신 대입 연산자 다음에 표현식(실향 코드) 정의.
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
    100 -> "best condition!"
    in 90..99 -> "some scratch."
    in 75..89 -> if (isBlessed) {
        "slight wound, but heal quickly."
    } else {
        "slight wound."
    }
    in 15..74 -> "hurt a lot."
    else -> "worst condition!"
}

private fun castFireBall(numFireBalls: Int = 2) = println("shoot fire ball. (x$numFireBalls)")
