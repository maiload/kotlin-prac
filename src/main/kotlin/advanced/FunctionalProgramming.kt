package advanced

/**
 * 코틀린에서 편리하게 함수형 프로그래밍을 적용하기 위한 라이브러리 : Arrow Core
 */

// 함수도 값이기 때문에 변수에 대입 가능
val func: () -> String = { "" }

val printHello: () -> Unit = { println("Hello") }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

fun printNo() = println("No!")

fun main() {

    val list = mutableListOf(printHello)
    val func = list[0]
    func()

    call(printHello)

    /**
     * 표현식이 아닌 func 으로 선언한 함수는 일급 객체의 특성을 사용할 수 없다
     */
//    val list2 = mutableListOf(printNo)
//    call(printNo)

    val result: Int = plus(1, 3, 5)
    println(result)


    val list2 = listOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }
    forEachStr(list2, printStr)
    
    // 후행 람다 전달 (함수 전달 인자가 함수 하나이거나, 제일 마지막에 있는 경우)
    forEachStr(list2) {
        println(it)
    }


    // 전달 인자가 1개인 경우 it 사용
    arg1{
        it.length
    }
    // 전달 인자가 2개 이상인 경우 직접 선언하고 사용
    arg2{ a: String, b: String ->
        a.length
        b.length
    }


    outerFunc()()
    outerFunc2()()


    // lambda reference
    val callReference: () -> Unit = { printHello() }
    callReference()
    val callReference2 = ::printHello
    callReference2()()

    val numberList = listOf("1", "2", "3")
    numberList.map{ it.toInt() }.forEach { println(it) }
    numberList.map(String::toInt).forEach(::println)
}

val printMessage: (String) -> Unit = { message: String -> println(message) }
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }

val plus: (Int, Int, Int) -> Int = {a, b, c -> a + b + c}


// 고차 함수 (함수를 전달 받아 처리하는 함수)
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

fun arg1(blcok: (String) -> Unit) {}
fun arg2(blcok: (String, String) -> Unit) {}

// 익명 함수
fun outerFunc(): () -> Unit {
    return fun() {
        println("이것은 익명 함수!")
    }
}

// 람다 함수
fun outerFunc2(): () -> Unit = { println("이것은 람다 함수!") }

// 람다 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
// 람다 축약 식
val sum2 = { x: Int, y: Int -> x + y }

