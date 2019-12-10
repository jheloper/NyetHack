/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val race = "gnome"

    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "No faction"
    }
    println("$name faction is $faction")

    // aura
    val auraInvisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraInvisible) "green" else "none"

    val healthStatus = when (healthPoints) {
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
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}