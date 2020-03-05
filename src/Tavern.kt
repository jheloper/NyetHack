/**
 * @author joonghyeon.kim
 */

fun main(args: Array<String>) {
    val signatureDrink = "Beer"

    // orderBeverage1(signatureDrink)

    // orderBeverage2()

    // orderBeverage3(signatureDrink)

    orderBeverage4()
}

fun orderBeverage1(signatureDrink: String) {
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

fun orderBeverage2() {
    // 더블 뱅 연산자(=non null 단언 연산자)로 null이 될 수 없음을 단언할 수 있다.
    var beverage = readLine()!!.capitalize()
    println(beverage)
}

fun orderBeverage3(signatureDrink: String) {
    // 아래처럼 if로 검사할 수 있다.
    var beverage = readLine()
    beverage = null
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("beverage is null!")
    }
    println(beverage)

    // null 복합 연산자(=Elvis 연산자)를 사용하여 null인 경우와 null이 아닌 경우에 대해서 처리할 수 있다.
    val beverageServed: String = beverage ?: signatureDrink
    println(beverageServed)
}

fun orderBeverage4() {
    // null 복합 연산자와 let 함수를 아래처럼 함께 사용할 수 있다.
    var beverage = readLine()
    // beverage = null
    beverage?.let {
        beverage = it.capitalize()
    } ?: println("beverage is null!")
    println(beverage)
}