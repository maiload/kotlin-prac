package org.example.basic

import basic.Java_NullSafety

fun main() {

    // 컴파일 단계에서 null 체크 가능
//    var a : String = null

    // 안전 연산자 (?)
    var a : String? = null
//    a.length
    println(a?.length)

    val b : Int = if (a != null) a.length else 0
    println(b)

    // 엘비스 연산자 (?:) -> 좌변이 null 인 경우 우변을 리턴
    val c = a?.length ?: 0
    println(c)




    val nullableStr = getNullStr()

    val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
    println(nullableStrLength)

    val lenth = getLengthIfNotNull(null)
    println(lenth)




    // NPE 발생 케이스 1 -> 직접 발생
    throw NullPointerException()

    // NPE 발생 케이스 2 -> 단언 연산자(!!) 사용
    val d : String? = null
    val e = d!!.length

    // NPE 발생 케이스 3 -> 자바 코드와 연계
    println(Java_NullSafety.getNullStr().length)
}

fun getNullStr() : String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?: 0