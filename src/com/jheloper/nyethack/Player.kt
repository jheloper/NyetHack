package com.jheloper.nyethack

class Player(_name: String,
             _race: String,
             _healthPoints: Int,
             _isBlessed: Boolean,
             _isImmortal: Boolean) {
    var name = _name
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }
    val race = _race
    var healthPoints = _healthPoints
    val isBlessed = _isBlessed
    private val isImmortal = _isImmortal

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        return if (auraVisible) selectAuraColor() else "NONE"
    }

    private fun selectAuraColor(): String {
        return when ((Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()) {
            in 0..5 -> "RED"
            in 6..10 -> "ORANGE"
            in 11..15 -> "PURPLE"
            in 16..20 -> "GREEN"
            else -> "NONE"
        }
    }

    fun formatHealthStatus() = when (healthPoints) {
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

    fun faction() = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "No faction"
    }

    fun castFireBall(numFireBalls: Int = 2) = println("shoot fire ball. (x$numFireBalls)")
}