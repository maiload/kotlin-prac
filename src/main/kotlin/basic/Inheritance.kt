package basic

// 자바에서 모든 클래스의 조상이 Object 인것처럼, 코틀린에서 모든 클래스의 조상은 Any 이다
// 코틀린의 클래스는 기본적으로 final 키워드를 갖고 있어, 상속이 불가능하다

open class Dog {        // 상속을 위해서는 open 키워드 사용
    open var age: Int = 0
    
    open fun bark() {
        println("멍멍")
    }
}

// 클래스 상속 후 재정의
class Bulldog: Dog() {
    override var age : Int = 0
    
    override fun bark() {
        println("왈왈")
    }
}

// 기본생성자를 통해서 재정의 가능
open class Bulldog2(override var age : Int = 0): Dog() {

    final override fun bark() {
        println("왈왈")
    }
}

class ChildBulldog: Bulldog2() {
    // 오버라이드된 값 또는 함수는 자동으로 open 키워드 적용
    override var age: Int = 0

    // 명시적으로 final 을 붙인 경우에는 오버라이드 불가능
//    override fun bark() {
//        super.bark()
//    }
}

abstract class Developer {

    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int = 0): Developer() {

    override fun code(language: String) {
        println("I code with $language")
    }
}

fun main() {
    val dog = Bulldog2(age = 2)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(age = 20)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")
}