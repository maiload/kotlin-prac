package advanced

import java.io.FileWriter

fun main() {
    // 자바의 try-with-Resources 와 같은 기능을 한다 -> auto close
    FileWriter("test.txt").use {
        it.write("Hello Kotlin")
    }
}