/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordJuggling = 2
    }

    try {
        proficiencyCheck(swordJuggling)
        // 아래 코드는 상황에 따라 KotlinNullPointerException을 발생시키고 프로그램이 종료된다.
        swordJuggling = swordJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("juggle $swordJuggling swords!")
}

fun proficiencyCheck(swordJuggling: Int?) {
    swordJuggling ?: throw UnskilledSwordJugglerException()
}

class UnskilledSwordJugglerException(): IllegalStateException("player can not juggling!")