import jdk.internal.dynalink.support.Guards.isInstance
import kotlin.jvm.internal.Lambda

//import java.util.*
//import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt

//fun binSearch(needle: Int, haystack: IntArray, start: Int, end: Int): Int {
//    if (start > end)
//        return -1
//    val mid = (start + end) / 2
//    when {
//        needle == haystack[mid] -> return mid
//        needle < haystack[mid] -> return binSearch(needle, haystack, start, mid - 1)
//        needle > haystack[mid] -> return binSearch(needle, haystack, mid + 1, end)
//    }
//}
//
//fun binarySearch(needle: Int, haystack: IntArray): Int {
//    return binSearch(needle, haystack, 0, haystack.lastIndex)
//}

fun main(args: Array<String>) {
    val s1 = "aeiou"


    println(s1.all { it < 'z' })
    println(s1.any { it < 'a' })

    println(s1.plus(123))
    println(s1.subSequence(0, s1.length))

    val map1 = mutableMapOf<Char, Int>()
    if (map1.containsKey('a'))
        println("ok")
    if ('a' in map1)
        println("ok")

    val set1 = mutableSetOf(1, 2, 3, 4, 5)
    val set2 = mutableSetOf(1, 2, 3)
    println(set1.containsAll(set2))
    println(set2.containsAll(set1))

    val list1 = mutableListOf(2, 4, 6, 1, 3, 5)
    println(list1.takeLastWhile { it > 1 })

    println("asdf jkl; qwer".split(" "))
    println("abcde".takeLastWhile { it > 'b' })

    for ((i, e) in list1.withIndex())
        println("index=$i   element=$e")

    println("10".toInt())

    println("asdf jkl;".filter { it != ' ' })

    val n = 12300
    println(n.toString().trim('0').toInt())

    val n1 = 4
    var s = ""
    for (i in 0..n1 - 1)
        s += if (i % 2 == 0) "1" else "0"
    println(s)

    println((1..n1)
            .map { (it % 2).toString() }
            .joinToString(""))

    println(cube(3))
    println(Math.E)
    println(Math.PI)

    val s2 = "abcde"
    println(s2.map { if (it.isUpperCase()) it.toLowerCase() else it.toUpperCase() }
            .joinToString(""))

    val arr1 = arrayOf(1, 2, 3)
    println(arr1.sum() - arr1.min().toString().toInt() - arr1.max().toString().toInt())
    println(arr1.sorted().filterIndexed { i, n -> i != 0 && i != arr1.lastIndex }.sum())

    val list12345 = 12345.toString().reversed().map { it.toInt() - 48 }
    println(list12345)

}

fun cube(x: Int): Int = x * x * x

