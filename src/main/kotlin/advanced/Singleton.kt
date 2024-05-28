package advanced

import java.time.LocalDateTime

object DatetimeUtils {

    val now : LocalDateTime
        get() = LocalDateTime.now()

    // 상수
    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime) : Boolean {
        return a == b
    }
}

fun main() {
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)

    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))



    println(MyClass.a)
    println(MyClass.newInstance())
}

class MyClass private constructor() {

    // 동반 객체 (객체명 생략 가능)
    /**
     * 1. 클래스 메서드처럼 사용 가능
     * 2. 싱글톤 패턴 구현 가능
     */
    companion object MyCompanion {
        val a = 1234

        fun newInstance() = MyClass()
    }
}