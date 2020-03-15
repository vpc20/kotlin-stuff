fun <T> listDepth(list1: List<T>): Int {
    var depth = 0
    for (e in list1)
        if (e is List<*>)
            depth = listDepth(e)
    return 1 + depth
}

fun <T> listDepth1(list1: List<T>): Int {
    var depth = 0
    list1.filterIsInstance<List<*>>().forEach { depth = listDepth(it) }
    return 1 + depth
}

fun <T> listDepthIterative(list1: List<T>): Int {
    var depth = 1
    val q = mutableListOf(list1)

    while (q.isNotEmpty()) {
        val currList = q[0]
        var listFound = false
        for (e in currList) {
            if (e is List<*>) {
                listFound = true
                q.add(e as List<T>)
            }
        }
        if (listFound)
            ++depth
        q.removeAt(0)
    }
    return depth
}

fun main(args: Array<String>) {

//    val mutlist1 = mutableListOf(1, 2, 3)
//    val mutlist2 = mutableListOf(4, 5, 6)
//    println(mutlist1 + mutlist2)


    val list1 = listOf(1, 2, 3)
    val list2 = listOf(listOf(1, 2, 3), listOf(4, 5, 6), 7)
    val list3 = listOf(listOf(1, 2, 3), listOf(4, 5, listOf(6, 7)), 8)
    println(listDepth(list1))
    println(listDepth(list2))
    println(listDepth(list3))
    println(listDepth1(list1))
    println(listDepth1(list2))
    println(listDepth1(list3))
    println(listDepthIterative(list1))
    println(listDepthIterative(list2))
    println(listDepthIterative(list3))

}
