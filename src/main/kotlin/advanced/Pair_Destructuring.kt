package advanced

// f((1, 3)) = 1 + 3 = 4
// f(1, 3) = 1 + 3 = 4

data class Tuple(val a: Int, val b: Int)

fun plus(a: Int, b: Int) = a + b
fun plus2(tuple: Tuple) = tuple.a + tuple.b
fun plus3(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    println(plus(1, 3))

    val plus2 = plus2(Tuple(1, 3))
    println(plus2)

    val plus3 = plus3(Pair(1, 3))
    println(plus3)

    val pair = Pair("A", 1)
//    pair.first = "B"      -> 불변객체라 직접 변경 불가능
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList()     // -> 불변 리스트
    println(list)

    // 3개까지는 내장 tuple 을 제공  -> 그 이상은 직접 생성
    val triple = Triple("A", "B", "C")
    println(triple)
    triple.first
    triple.second
    triple.third


    // 구조분해 문법  -> 내부적으로 componentN 메서드를 사용
    // tuple, data class, 배열, 리스트, 맵 등에서 사용 가능
    val (a: String, b: String ,c: String) = triple      // 자료형은 생략 가능
    println("$a, $b, $c")

    val list3: List<String> = triple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")
    list3.component5()      // 배열과 리스트는 componentN 메서드를 5까지만 제공
    
    val map = mutableMapOf("이정진" to "개발자")  // 내부적으로 Pair 를 사용
    for ((key, value) in map) {
        println("${key}의 직업은 $value")
    }
}
