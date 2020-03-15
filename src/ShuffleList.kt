import java.util.*

private fun <E> List<E>.shuffle(): List<E> {
    val mutList = this.toMutableList()
    val r = Random()
    for (i in 1..this.lastIndex)
        mutList.swapInPlace(i, r.nextInt(i + 1))
    return mutList.toList()
}

private fun <E> MutableList<E>.shuffleInPlace() {
    val r = Random()
    for (i in 1..this.lastIndex) {
        val n = r.nextInt(i + 1)
        this.swapInPlace(i, n)
    }
    return
}

fun main(args: Array<String>) {
    println(listOf(1, 2, 3, 4, 5).shuffle())

    val mutList1 = mutableListOf(1, 2, 3, 4, 5)
    mutList1.shuffleInPlace()
    println(mutList1)
}
