fun isPangram(s: String) = s.toSet().containsAll("abcdefghijklmnopqrstuvwxyz".toSet())

fun main(args: Array<String>) {
    println(isPangram("the quick brown fox jumps over the lazy dog"))
    println(isPangram("abcdefghijklmnopqrstuvwxyz"))
}