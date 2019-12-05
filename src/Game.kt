/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false;

    // aura
    if (isBlessed && healthPoints > 50 || isImmortal) {
        println(name + " aura is green")
    } else {
        println(name + " aura is none")
    }

    if (healthPoints == 100) {
        println(name + " best condition!")
    } else if (healthPoints >= 90) {
        println(name + " some scratch.")
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            println(name + " slight wound, but heal quickly.")
        } else {
            println(name + " slight wound.")
        }
    } else if (healthPoints >= 15) {
        println(name + " hurt a lot.")
    } else {
        println(name + " worst condition!")
    }
}