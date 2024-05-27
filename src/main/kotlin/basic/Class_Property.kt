package basic

// 클래스를 생성할 때 생성자를 같이 선언 가능 -> constructor 키워드는 주로 생략
class Coffee constructor(
    var name: String = "",
    var price: Int = 0,
    var iced: Boolean = false,  // 코틀린에서는 후행 쉼표가 가능
){
    // 함수가 아닌 클래스에서 생성된 변수는 property 라고 하며 반드시 초기화해야 한다
    // 커스텀 getter, setter 생성 가능
    val brand: String
        get() {
            return "스타벅스"
        }

    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                // 프로퍼티 접근 키워드인 field 를 사용해야한다 (Backing fields)
                // 직접 할당할 경우 무한 재귀호출이 되어 StackOverflowError 발생
                field = value
//                quantity = value
            }
        }
}

// 빈 클래스 생성 가능
class EmptyClass

fun main() {
    val coffee = Coffee()
    // 코틀린의 컴파일러가 getter, setter 를 자동으로 생성해준다
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true
    
    if (coffee.iced){
    // 어떠한 상태를 나타낼 때 (비록 내부적으로는 getter 를 사용하는 것이지만)
    // 코드상으로는 프로퍼티를 사용하기 때문에 자바보다 더 객체지향적이다
        println("아이스 커피")
    }

    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")
}