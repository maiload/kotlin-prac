package advanced

class MyGenerics<out T>(val t: T){
    
}

class Bag<T>{
    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>
    ){
        to.addAll(from)
    }
}

fun main() {
    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 type argument 제공
    // 생성자에서 값을 받기 때문에 컴파일러가 타입을 추론 가능하여 타입 생략 가능
    val generics = MyGenerics<String>("테스트")

    // 변수 타입에 제네릭을 사용
    val list1: MutableList<String> = mutableListOf()
    // 생성자에서 type argument 추가
    val list2 = mutableListOf<String>()

    val list3: List<*> = listOf<String>("테스트")
    val list4: List<*> = listOf<Int>(1, 2, 3, 4)


    // PECS(Producer-Extends, Consumer-Super)
    // 공변성은 자바 제네릭의 extends, 코틀린에서는 out
    val charGenerics: MyGenerics<CharSequence> = generics

    // 반공변성은 자바 제네릭의 super, 코틀린에서는 in
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))
}