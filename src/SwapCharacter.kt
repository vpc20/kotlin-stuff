//fun swapChar(s: String, i: Int, j: Int): String {
//    if (i == j)
//        return s
//
//    val x: Int
//    val y: Int
//
//    if (i < j) {
//        x = i; y = j
//    } else {
//        x = j; y = i
//    }
//    return s.slice(0..x - 1) + s.slice(y..y) + s.slice(x + 1..y - 1) + s.slice(x..x) + s.slice(y + 1..s.lastIndex)
//}

fun <T> MutableList<T>.swapInPlace(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun List<Any>.swap(index1: Int, index2: Int): List<Any> {
    val mutList = this.toMutableList()

    val tmp = mutList[index1]
    mutList[index1] = mutList[index2]
    mutList[index2] = tmp

    return mutList.toList()
}

fun String.swapChar(i: Int, j: Int): String {
    return this.toList().swap(i, j).joinToString("")
}

fun main(args: Array<String>) {
//    println(swapChar("abcde", 0, 0))
//    println(swapChar("abcde", 0, 1))
//    println(swapChar("abcde", 1, 0))
//    println(swapChar("abcde", 1, 3))
//    println(swapChar("abcde", 3, 4))
//    println(swapChar("abcde", 4, 3))

//    println("abcde".swapChar(0, 0))
    println("abcde".swapChar(0, 1))
}