package advanced

class LateInit {
    // 반드시 가변 프로퍼티를 사용해야 하는 경우에 사용 -> autowired, setup 등
    // nullable 해야 한다
    lateinit var text: String
    
    fun printText() {
//        text = "안녕하세요"
        if (this::text.isInitialized) {     // isInitialized 메서드로 초기화 여부를 확인 가능 -> 클래스 외부에서는 사용 불가능
            println("초기화 됨")
        } else{
            text = "안녕하세요"
        }
        println(text)
    }
}

fun main() {
    val test = LateInit()
    test.printText()
}