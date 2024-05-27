package basic

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

interface Cart: Wheel {

    var coin: Int

    // 인터페이스에서는 backing fields 사용 불가
    val weight: String
        get() = "20KG"

    fun add(product: Product)

    // default method
    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다")
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다")
    }

    fun printId() = println("5678")
}

class MyCart(override var coin: Int) : Cart, Order {
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가됐습니다")

        // 상위 인터페이스의 디폴트 메서드 사용
        super<Order>.add(product)
    }

    // 상위 인터페이스에 동일한 함수명을 가진 디폴트 메서드가 있다면 오버라이드 해야 한다
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId()
}