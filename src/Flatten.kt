import kotlin.coroutines.experimental.buildIterator

fun main(args: Array<String>) {
    val list1 = listOf(9, listOf(1, 2, 3), listOf(4, 5, listOf(6, 7)), 8)
    println(list1)
    println(flatten1(list1))
    println(flattenx(list1))
    println(flattenIterative(list1))

    for (item in flattenIterator(list1))
        println(item)
    println(flattenIterator(list1).asSequence().toList())

    println("'flattenIterator1")
    for (item in list1.flattenIterator1())
        println(item)

    println("flattenIterator2")
    for (item in list1.flattenIterator2())
        println(item)

}


private fun <T> flatten1(list: List<T>): List<T> {
    val mutList1 = mutableListOf<T>()
    for (item in list) {
        if (item is List<*>)
            mutList1 += flatten1(item) as MutableList<T>
        else
            mutList1.add(item)
    }
    return mutList1.toList()
}

fun <T> flattenx(list: List<T>): List<T> {
    val mutList = mutableListOf<T>()
    fun flattenx(list1: List<T>): MutableList<T> {
        for (item in list1) {
            if (item is List<*>)
                flattenx(item as List<T>)
            else
                mutList.add(item)
        }
        return mutList
    }
    return flattenx(list)
}

fun <T> flattenIterative(list: List<T>): List<T> {
    val q = mutableListOf(list)
    val mutList = mutableListOf<T>()

    while (q.isNotEmpty()) {
        val currList = q[0]
        for (e in currList) {
            if (e is List<*>)
                q.add(e as List<T>)
            else
                mutList.add(e)
        }
        q.removeAt(0)
    }
    return mutList.toList()
}

fun <T> flattenIterator(list: List<T>): Iterator<Any?> = buildIterator {
    for (item in list) {
        if (item is List<*>)
            for (i in flattenIterator(item))
                yield(i)
        else
            yield(item)
    }
}

fun <T> List<T>.flattenIterator1(): Iterator<Any?> = buildIterator {
    for (item in this@flattenIterator1) {
        if (item is List<*>)
            for (i in item.flattenIterator1())
                yield(i)
        else
            yield(item)
    }
}

fun <T> List<T>.flattenIterator2(): Iterator<Any?> = buildIterator {
    for (item in this@flattenIterator2) {
        if (item is List<*>)
            yieldAll(item.flattenIterator1())
        else
            yield(item)
    }
}




