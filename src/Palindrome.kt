fun palindrome(s: String) =
        if (s.isEmpty())
            true
        else
            (0..(s.lastIndex / 2)).all { s[it] == s[s.lastIndex - it] }

//fun palindrome(s: String): Boolean =
//        when {
//            s.isEmpty() || s.length == 1 -> true
//            s.first() != s.last() -> false
//            else -> palindrome(s.slice(1..s.lastIndex - 1))
//        }

fun main(args: Array<String>) {
    println(palindrome(""))
    println(palindrome("a"))
    println(palindrome("aba"))
    println(palindrome("abba"))
    println(palindrome("abcba"))
    println(palindrome("ab"))
//    print(0.rangeTo(-1).forEach(::println))
    println("".lastIndex)
    val s = "asdf"
    println(s[s.length - 1])
    println(s.slice(s.length - 2..s.lastIndex))
    println(s.takeLast(2))
}
