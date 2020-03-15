fun main(args: Array<String>) {
    println(combineStrings(emptyList()))
    println(combineStrings(listOf("Python")))
    println(combineStrings(listOf("Python", "Ruby")))
    println(combineStrings(listOf("Python", "Ruby", "Java")))
}

fun combineStrings(list1: List<String>) =
        when {
            list1.isEmpty() -> ""
            list1.size == 1 -> list1[0]
            else -> list1.slice(0..list1.size - 2).joinToString(", ") + " and " + list1.last()
        }

