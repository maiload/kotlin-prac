package advanced

// sealed 클래스는 같은 패키지 내에서만 상속이 가능하다
sealed class Developer {

    abstract val name: String
    abstract fun code(language: String)
}
//abstract class Developer {
//
//    abstract val name: String
//    abstract fun code(language: String)
//}

data class BackendDeveloper (override val name: String): Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용합니다")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다 ${language}를 사용합니다")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    // abstract 클래스로 선언할 경우 컴파일러가 하위 클래스가 2개 뿐이라는 것을 인식하지 못해 else 문이 필요하지만
    // sealed 클래스로 선언하면 컴파일러가 하위 클래스를 인식가능하여 else 문이 불필요하다
    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
//        else -> {
//            println("지원하지 않는 개발자입니다")
//        }
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "tony")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "david")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("tony"))
    println(DeveloperPool.get("david"))
}