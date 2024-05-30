package advanced

class HelloBot {

    /**
     * 불변성을 유지하면서 지연 로딩 가능 (최초 1회만 실행) -> Thread Safe
     * 멀티스레드 환경이 아니라면 LazyThreadSafetyMode.NONE, LazyThreadSafetyMode.PUBLICATION 옵션 사용 가능
     */
    val greeting: String by lazy {
        println("초기화 로직 수행")
        getHello()
    }
//    var greeting: String? = null

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()

//    helloBot.greeting = getHello()

//    helloBot.sayHello()
//    helloBot.sayHello()
//    helloBot.sayHello()
    println("초기화 전")

    for (i in 1..5) {
        Thread{
            helloBot.sayHello()
        }.start()
    }
}