package basic

enum class PaymentStatus(val label: String): Payable {
    UNPAID("미지급") {
        override fun isPayable(): Boolean = true
    },
    PAID("지급완료") {
        override fun isPayable() = false
    },
    FAILED("지급실패") {
        override fun isPayable() = false
    },
    REFUNDED("환불") {
        override fun isPayable() = false
    };     //함수를 정의할 경우 세미콜론을 붙여야 한다

//    abstract fun isPayable(): Boolean     -> 재사용성을 위해 인터페이스로 분리
}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {
    println(PaymentStatus.UNPAID.label)

    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }

    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)
    
    // enum 클래스는 싱글톤 패턴
    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    for (status in PaymentStatus.values()) {
        // enum 클래스에서 기본 제공되는 프로퍼티  -> name(상수명), ordinal(순서)
        println("[${status.name}](${status.label}) : ${status.ordinal}")
    }
}