import java.util.*

private fun <T> Random.choice(list: List<T>): T {
    return list[Random().nextInt(list.size)]
}

fun main(args: Array<String>) {
    println(Random().choice(listOf(1, 2, 3, 4, 5)))
    println(Random().choice(listOf("car", "goat", "goat")))
}
