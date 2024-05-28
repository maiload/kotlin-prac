package advanced

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {

    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본값"       // catch 문 마지막이 반환값
    }
    println(result)


    val result2 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"       // getOrElse 함수 마지막이 반환값
        }
    println(result2)


    val result3 = runCatching { "성공?" }
        .getOrNull()
    println(result3)


    val result4 = runCatching { getStr() }
        .exceptionOrNull()

    result4?.let {
        println(it.message)
        throw it
    }
    
    
    val result5 = runCatching { getStr() }
        .getOrDefault("기본 값")
    println(result5)


    val result6: String = runCatching { "성공" }
        .getOrThrow()


    val result7: String = runCatching { "안녕" }
        .map {
            "${it}하세요"
        }.getOrThrow()
    
    
    val result8 = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }.getOrDefault("기본 값")


    val result9 = runCatching { getStr() }
        .recover { "복구" }
        .getOrNull()


    val result10 = runCatching { getStr() }
        .recoverCatching { 
            throw Exception("예외")
        }.getOrDefault("복구")
}