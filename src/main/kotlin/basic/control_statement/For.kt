package basic.control_statement

fun main() {

    // 범위 연산자(..) 사용 -> <= x <=
    for (i in 0..3) {
        println(i)
    }

    // until 을 사용 -> <= x <
    for (i in 0 until 3) {
        println(i)
    }

    // downTo 를 사용 -> >= x >=
    for (i in 6 downTo 0) {
        println(i)
    }

    // step 을 사용하여 값 조절
    for (i in 0..6 step 2) {
        println(i)
    }
    
    // 전달받은 배열을 반복
    val number = arrayOf(1, 2, 3)

    for (i in number) {
        println(i)
    }

}