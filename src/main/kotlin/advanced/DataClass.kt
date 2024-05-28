package advanced

// 데이터 클래스 사용 시 컴파일러가 자동으로 equals, hashcode, toString, componentN, copy 와 같은 함수를 자동으로 생성
// kotlin bytecode 기능으로 decompile 하여 자바 코드로 확인 가능

data class Person(val name: String, val age: Int)

fun main() {
    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)

    println(person1 == person2)

    val set = hashSetOf(person1)
    println(set.contains(person2))

    println(person1.toString())

    // var 로 프로퍼티를 설정할 경우 추후 예기치 않은 오류가 발생할 수 있어 불변객체로 사용하는 것을 권장 -> copy 사용
//    person1.name = "strange"
//    println(set.contains(person1))

    val person3 = person1.copy(name = "strange")
    println(person3)

    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    // 구조분해할당
    val (name, age) = person1
    println("이름=$name, 나이=$age")

}