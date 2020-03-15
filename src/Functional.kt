//fun mapList(arr: List<Int>, func: (Int) -> Int): List<Int> {
//    val mlist = mutableListOf<Int>()
//    for (item in arr)
//        mlist.add(func(item))
//    return mlist
//}

fun List<Int>.mapList(f: (Int) -> Int): List<Int> {
    val mlist = mutableListOf<Int>()
    for (item in this)
        mlist.add(f(item))
    return mlist
}

fun <T, R> Iterable<T>.mapIterable(transform: (T) -> R): List<R> {
    val mlist = mutableListOf<R>()
    for (item in this)
        mlist.add(transform(item))
    return mlist
}

fun main(args: Array<String>) {
    val list1 = listOf(1, 2, 3, 4, 5)
    val set1 = setOf(1, 2, 3, 4, 5)
    val map1 = mapOf(1 to 2, 3 to 4)

    for ((k, v) in map1)
        println("$k  $v")
    map1.map { e -> println("key=${e.key}  value=${e.value}") }
    println(list1.mapList { it * it })
    println(list1.mapIterable { it * it })
    list1.map { it }
    set1.map { it }
}