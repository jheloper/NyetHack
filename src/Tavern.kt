import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"
const val WELCOME_TAVERN_SENTENCE = "*** Welcome to $TAVERN_NAME ***"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastNames = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val patronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>) {
    val signatureDrink = "Beer"

    // orderBeverage1(signatureDrink)

    // orderBeverage2()

    // orderBeverage3(signatureDrink)

    // orderBeverage4()

    // placeOrder("shandy,Dragon's Breath,5.91")
    // placeOrder("elixir,Shirley's Temple,5.91")

    // printOmSymbol()

    // printCharactersInSentence("Dragon's Breath")

    // println(patronList)
    // println(patronList[1])
    // println(patronList.first())
    // println(patronList.last())
    // println(patronList.getOrElse(3) { "Unknown Patron(getOrElse)" })
    // println(patronList.getOrNull(3) ?: "Unknown Patron(getOrNull)")

    // if (patronList.contains("Eli")) {
    //     println("Tavern master said: Eli play the card inside that room.")
    // } else {
    //     println("Tavern master said: Eli is not here.")
    // }

    // if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
    //     println("Tavern master said: Yes, they are here.")
    // } else {
    //     println("Tavern master said: No, someone had get out of here.")
    // }

    val readOnlyPatronList = patronList.toList()

    patronList.remove("Eli")
    patronList.add("Alex")
    patronList.add(0, "Romeo")
    patronList[0] = "Michael"

    println(patronList)
    println(readOnlyPatronList)

    // for (patron in patronList) {
    //     println("Good night, $patron")
    // }

    // patronList.forEach { patron ->
    //    println("Good night, $patron")
    // }

    val maxLength = WELCOME_TAVERN_SENTENCE.length

    var menuBoard = WELCOME_TAVERN_SENTENCE

    val menuList = File("data/tavern-menu-items.txt").readText().split(System.lineSeparator())
    menuList.forEach {
        val (type, name, price) = it.split(',')
        var dotString = ""
        (1..(maxLength - name.length - price.length)).forEach {
            dotString += "."
        }
        menuBoard += System.lineSeparator() + (name + dotString + price)
    }
    println(menuBoard)

    // patronList.forEachIndexed { index, patron ->
    //     println("Good evening, $patron - You are #${index + 1} in line.")
    //     placeOrder(patron, menuList.shuffled().first())
    // }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastNames.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }
    println(patronGold)

    var orderCount = 0
    while (true) {
        val isAvailable = orderCount <= 9
        if (!isAvailable) {
            break
        }
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    // printSamplePatronsMap()

    displayPatronBalances()
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price

//    val totalPurse = playerGold + (playerSilver / 100.0)
//    println("wallet total balance: $totalPurse Gold")
//
//    if (price > totalPurse) {
//        println("not enough wallet balance!")
//    } else {
//        println("purchase a drink, $price Gold")
//
//        val remainingBalance = totalPurse - price
//        println("remaining balance: ${"%.2f".format(remainingBalance)}")
//
//        val remainingGold = remainingBalance.toInt()
//        val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//        playerGold = remainingGold
//        playerSilver = remainingSilver
//        displayBalance()
//    }
}

private fun displayPatronBalances() {
    patronGold.forEach { (patron, balance) ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName do order to $tavernMaster")

    // val data = menuData.split(',')
    // val type = data[0]
    // val name = data[1]
    // val price = data[2]

    // 아래와 같이 해체 선언(destructing declaration)을 사용할 수 있다.
    val (type, name, price) = menuData.split(',')
    val message = "Type: ${type}, Name: ${name}, Price: ${price}"
    println(message)

    performPurchase(price.toDouble(), patronName)

    // 코틀린의 문자열 비교는 기본적으로 값이 같은지를 비교하기 때문에 아래와 같이 ==를 사용하면 된다.
    val phrase = if (name == "Dragon's Breath") {
        "$patronName feel amazing: ${toDragonSpeak("wow, awesome $name!")}"
    } else {
        "$patronName said: Thanks, $name"
    }
    println(phrase)

    // val upperCasePhrase = toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE!")
    // println(upperCasePhrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }

private fun printSamplePatronsMap() {
    val samplePatron = mutableMapOf(
        "Eli" to 10.5,
        "Mordoc" to 8.0,
        "Sophie" to 5.5
    )
    println(samplePatron)

    samplePatron += "Sophie" to 7.0
    println(samplePatron)

    println(
        mapOf(
            "Eli" to 10.5,
            "Mordoc" to 8.0,
            "Sophie" to 5.5,
            "Sophie" to 6.25
        )
    )

    println(samplePatron["Eli"])
    println(samplePatron["Mordoc"])
    println(samplePatron["Sophie"])
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

fun printOmSymbol() {
    // 아래와 같이 유니코드 코드값으로 유니코드 문자를 지정할 수 있다.
    val omSymbol = '\u0950'
    println(omSymbol)
}

fun printCharactersInSentence(sentence: String) {
    // String의 forEach로 문자 하나씩 순회 가능하다.
    sentence.forEach {
        println("$it")
    }
}