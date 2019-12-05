/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89

    if (healthPoints == 100) {
        println(name + " best condition!")
    } else if (healthPoints >= 90) {
        println(name + " some scratch.")
    } else if (healthPoints >= 75) {
        println(name + " slight wound.")
    } else if (healthPoints >= 15) {
        println(name + " hurt a lot.")
    } else {
        println(name + " worst condition!")
    }
}