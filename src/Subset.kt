fun main(args: Array<String>) {
    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(1, 2, 3)
    println(set2.isSubsetOf(set1))
}

fun <E> Set<E>.isSubsetOf(set1: Set<E>) = this.all { it in set1 }

