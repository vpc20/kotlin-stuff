fun main(args: Array<String>) {
    val list1 = listOf(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10), listOf(11, 12, 13, 14, 15))

    println(list1.size)
    println(list1[0].size)
    println(list1.transpose())
    println(list1.transpose1())
}

private fun <E> List<List<E>>.transpose(): List<List<E>> {
    val result = mutableListOf<List<E>>()
    val temp = mutableListOf<E>()
    for (i in 0..this[0].size - 1) {
        temp.clear()
        (0..this.size - 1).mapTo(temp) { this[it][i] }
        result.add(temp.toList())
    }
    return result.toList()
}

private fun <E> List<List<E>>.transpose1() =
        (0..this[0].size - 1).map { i ->
            (0..this.size - 1).map { j -> this[j][i] }.toList()
        }.toList()
