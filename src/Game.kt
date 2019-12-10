/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // aura
    val auraInvisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraInvisible) "green" else "none"
    println(name + " aura is " + auraColor)

    val healthStatus = if (healthPoints == 100) {
        "best condition!"
    } else if (healthPoints >= 90) {
        "some scratch."
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            "slight wound, but heal quickly."
        } else {
            "slight wound."
        }
    } else if (healthPoints >= 15) {
        "hurt a lot."
    } else {
        "worst condition!"
    }
    println(name + " " + healthStatus)
}