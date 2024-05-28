package advanced

// 코틀린은 기존의 내장된 클래스에 커스텀 메서드를 추가할 수 있다
// this 는 receiver(입력 받을 값)이다
fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char) : String {
    return char + this.substring(0)
}

class MyExample {
    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage() = println("확장 출력")

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    // 클래스의 멤버 메서드와 확장 메서드명이 같은 경우 멤버 메서드가 우선된다
    MyExample().printMessage()

    var myExample: MyExample? = null
    myExample.printNullOrNotNull()  // 메서드 내부에서 null 처리를 해주기 때문에 컴파일러가 이를 인식하고 안전연산자가 없어도 에러가 발생하지 않는다

    myExample = MyExample()
    myExample.printNullOrNotNull()
}