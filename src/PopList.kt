fun <T> MutableList<T>.pop(index: Int): T {
    val e = this[index]
    this.removeAt(index)
    return e
}

fun main(args: Array<String>) {
    val list1 = mutableListOf(1, 2, 3)
    println(list1.pop(0))
    println(list1)
}