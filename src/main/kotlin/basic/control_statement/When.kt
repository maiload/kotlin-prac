package basic.control_statement

fun main() {

    // 자바의 switch 문을 코틀린의 when 식으로 변환
    val day = 2
    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타"
    }
    println(result)
    
    // else 생략 가능
    // when 식의 조건으로 사용되는 enum 클래스의 결과값이 2개뿐이라는 것을 컴파일러가 인식할 수 있기 때문이다
    // 만약 enum 클래스에 값이 추가된다면 컴파일 오류가 발생
    val color = when(getColor()) {
        Color.RED -> "red"
        Color.GREEN -> "green"
    }
    println(color)
    
    // 여러 개의 조건을 콤마로 구분해 한 줄로 정의할 수 있다
    when (getNumber()) {
        0, 1 -> print("0 또는 1")
        else -> print("나머지")
    }

}

enum class Color {
    RED, GREEN
}

fun getColor() = Color.RED

fun getNumber() = 2
