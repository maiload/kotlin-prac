package basic

fun main() {

    // 코틀린은 자바와 달리 CheckedException 의 예외처리를 강요하지 않는다
    Thread.sleep(1)

    // 직접 처리 가능
    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("에러 발생!")
    } finally {
        println("finally 실행!")
    }
    
    // 표현식의 형태로 처리 가능
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생!")
    }
    println(a)



//    failFast("예외 발생")
    // nothing 타입의 값 이후의 코드는 실행될 수 없다고 컴파일 단계에서 확인 가능
    println("이 메세지는 출력 될까?")
    

    // nothing 타입의 반환값과 엘비스 연산자를 같이 사용할 경우 안전 연산자를 사용할 필요가 없어진다
    val b: String? = null
    val c: String = b ?: failFast("a is null")

//    println(c?.length)
    println(c.length)
}

    // 예외를 반환하는 경우 Nothing 을 반환타입으로 갖는다 (생략 가능)
fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}