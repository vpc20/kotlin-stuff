fun main(args: Array<String>) {
    println(listOf(1, 3, 5).containsEven())
}

private fun Collection<Int>.containsEven() = this.any { it % 2 == 0 }