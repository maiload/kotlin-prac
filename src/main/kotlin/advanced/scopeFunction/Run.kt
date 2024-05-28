package advanced.scopeFunction

class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null
    
    // DB에 접속하고 Boolean 결과를 반환
    fun connect(): Boolean {
        println("DB 접속 중 ...")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }
}

fun main() {
//    val config = DatabaseClient()
//    config.url = "localhost:3306"
//    config.username = "mysql"
//    config.password = "1234"
//    val connected = config.connect()

    // let 으로도 동일한 기능을 구현할 수 있지만,
    // run 은 수신자 객체가 생략 가능한 this이기 때문에 더 깔끔하게 구현 가능
    val connected = DatabaseClient().run {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()           // run 함수 마지막이 반환값
    }
    println(connected)
}