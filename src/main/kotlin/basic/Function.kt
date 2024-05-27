package basic

// 기본적인 함수 선언
fun sum(a: Int, b: Int) : Int {
    return a + b
}

// 표현식 스타일
fun sum2(a: Int, b: Int) : Int = a + b

// 표현식 & 반환타입 생략
// 몸통이 있는 함수는 반환 타입 제거 불가
fun sum3(a: Int, b: Int) = a + b

// 반환타입이 없는 함수는 Unit 을 반환한다 (생략 가능)
fun printSum(a: Int, b: Int) : Unit {
    println("$a + $b = ${a + b}")
}

// 디폴트 파라미터
fun greeting(message: String = "안녕하세요!!") {
    println(message)
}

//fun main() {
//    printSum(1, 2)
//    greeting()
//    greeting("HI!!!")
//}

fun log(level: String = "INFO", message: String) {
    println("[$level]$message")
}

fun main() {
    // named argument(변수값과 변수명을 매핑)
    log(message = "INFO LOGGING")
    log(level = "DEBUG", message = "DEBUG LOGGING")
    log("WARN", "WARN LOGGING")
    log("ERROR", message = "ERROR LOGGING")
}
