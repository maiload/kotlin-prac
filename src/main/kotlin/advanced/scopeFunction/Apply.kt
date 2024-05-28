package advanced.scopeFunction

fun main() {
    // 반환값이 함수의 마지막줄이 아닌, 컨텍스트 객체이다
    val client: DatabaseClient = DatabaseClient().apply {
        this.url = "localhost:3306"
        username = "mysql"
        password = "1234"
//        connect()
    }

    client.connect().run { println(this) }
}