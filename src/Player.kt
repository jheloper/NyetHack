class Player {
    var name = "madrigal"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    fun castFireBall(numFireBalls: Int = 2) = println("shoot fire ball. (x$numFireBalls)")
}