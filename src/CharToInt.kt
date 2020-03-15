fun main(args: Array<String>) {
    println('0'.toInt())
    println('0'.toInt() - 48)

    val c1 = 'a'
    println("Position of $c1 in alphabet: ${c1.toInt() - 96}")
    val c2 = 'A'
    println("Position of $c2 in alphabet: ${c2.toInt() - 64}")

    for (i in 1..256)
        println("$i -> ${i.toChar()}")

    for (i in 1..256)
        print("${i.toChar()}")

    val m1 = (1..256).map { it -> Pair(it, it.toChar()) }.filter { it -> it.second.isWhitespace() }
    for (item in m1)
        println(item)

}