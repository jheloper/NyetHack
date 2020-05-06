package com.jheloper.nyethack

import java.io.File

class Player(
    _name: String,
    val race: String,
    var healthPoints: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        set(value) {
            field = value.trim()
        }

    val hometown = selectHometown()

    init {
        require(healthPoints > 0, { "Health Points must be greater than 0." })
        require(name.isNotBlank(), { "Player must have a name."})
    }

    constructor(name: String) : this(
        name,
        race = "gnome",
        isBlessed = true,
        isImmortal = false
    ) {
        if (name.toLowerCase() == "kar") {
            healthPoints = 40
        }
    }

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

    private fun selectHometown() = File("data/towns.txt").readText().split(System.lineSeparator()).shuffled().first()
}