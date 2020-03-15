fun main(args: Array<String>) {
    val list1 = listOf(1, 2, 3, 4, 5)
    val list2 = listOf(10, 20, 30, 40, 50)
    println(list1.zip(list2))
    println(list1.zip(list2, { x, y -> x + y })) // same as zipWith below

    println(zipWith({ x, y -> x + y }, list1, list2))
}

fun zipWith(f: (Int, Int) -> Int, list1: List<Int>, list2: List<Int>) =
        (0..minOf(list1.lastIndex, list2.lastIndex)).map { f(list1[it], list2[it]) }
