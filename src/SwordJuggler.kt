/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordJuggling = 2
    }

    // 아래 코드는 상황에 따라 KotlinNullPointerException을 발생시키고 프로그램이 종료된다.
    swordJuggling = swordJuggling!!.plus(1)

    println("juggle $swordJuggling swords!")
}