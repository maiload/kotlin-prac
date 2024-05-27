package basic

var x = 5

fun main() {
    x += 1
    println(x)
    
    val a : Int = 1
    
    val b = 1   // 타입 생략
    
    val c : Int
    c = 3       // 지연 할당 (타입 선언 필수)

    // val (value)  -> 재할당 불가(read-only)
    // var (variable)

    var e : String = "Hello"
    e = "World"
}