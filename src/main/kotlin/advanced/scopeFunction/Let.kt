package advanced.scopeFunction

fun main() {

//    val str: String? = null
    val str: String? = "안녕"

    /**
     * null 이 아닌 경우에만 작동
     * 함수의 결과릎 반환
     */
    val result: Int? = str?.let {
        println(it)

        val abc: String? = "abc"
        abc?.let {
            val def: String? = "def"
            def?.let { 
                println("abcdef가 null 아님")      // 중복하여 사용 가능 -> 많이 중첩되는 경우 가독성을 해쳐 제어문 사용 권장
            }
        }

        1234        // let 함수 마지막이 반환값
    }

    println(result)
}