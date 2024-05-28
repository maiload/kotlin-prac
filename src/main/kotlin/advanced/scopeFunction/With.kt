package advanced.scopeFunction

fun main() {
    val str = "안녕하세요"

    // let, run 과 유사하지만, 확장함수가 아니다
    val length: Int = with(str) {
        length      // with 함수 마지막이 반환값
    }
    println(length)
}