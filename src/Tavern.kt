/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    var signatureDrink = "Beer"

    // 아래와 같이 안전 호출 연산자(?.)를 이용하면 반환값이 null이 아닌 경우에만 체이닝된 함수를 호출한다.
    var beverage = readLine()?.let {
        // let 함수로 해당 값이 null이 아닌 경우에 대한 처리를 추가할 수 있다.
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            signatureDrink
        }
    }
    // beverage = null

    println(beverage)
}