fun allSame(s: String): Boolean =
        if (s.isEmpty()) true else (0..s.lastIndex).all { s[it] == s[0] }

fun main(args: Array<String>) {
    println(allSame("aaa"))
    println(allSame("ab"))
}