package advanced

import java.util.LinkedList

fun main() {
    
    // immutable
    val currencyList = listOf("달러", "유로", "원")
//    currencyList.add()  -> 불가능

    // mutable
    val mutableCurrencyList: MutableList<String> = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("유로")
    mutableCurrencyList.add("원")

    val mutableCurrencyList2 = mutableListOf<String>().apply {
        this.add("달러")
        add("유로")
        add("원")
    }
    
    val mutableCurrencyList3 = mutableListOf("달러", "유로", "원")

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableNumberSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2)   // key to value

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    // put 메서드도 사용 가능하지만 권장 x
    mutableNumberMap["one"] = 1
    mutableNumberMap["two"] = 2
    println(mutableNumberMap["one"])
    
    // 컬렉션 빌더
    // 빌더 내부에서는 mutable, 반환값은 immutable
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }
//    numberList.add()

    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    //arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }


    // 방법 1
    var iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    // 방법 2
    for (currency in currencyList) {
        println(currency)
    }

    // 방법 3
    currencyList.forEach {
        println(it)
    }


    // for loop -> map
    val lowerList = listOf("a", "b", "c")

//    val upperList = mutableListOf<String>()
//    for (lowerCase in lowerList) {
//        upperList.add(lowerCase.uppercase())
//    }

    val upperList = lowerList.map { it.uppercase() }
    println(upperList)

    // for loop -> filter

//    val filteredList = mutableListOf<String>()
//    for (upperCase in upperList) {
//        if (upperCase == "A" || upperCase == "C") {
//            filteredList.add(upperCase)
//        }
//    }

    val filteredList = upperList.filter { it == "A" || it == "C" }
    // 자바와 달리 Terminal operation(최종 연산자)가 없이 사용 가능
    // 그러나 다루는 데이터량이 많아지거나 체인메서드가 많아지는 경우 asSequence() 를 사용 권장
    println(filteredList)
}
        