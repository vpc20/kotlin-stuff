fun uniqueLetter(s: String): Boolean = s.toSet().size == s.length

fun main(args: Array<String>) {
    println(uniqueLetter("abcde"))
    println(uniqueLetter("abcdc"))

}