fun multiples(n: Int): IntArray {
    return (1..n).filter { it % 3 == 0 && it % 5 == 0 }
            .toIntArray()
}

fun main(args: Array<String>) {
    multiples(100).forEach(::println)
}