fun same(n: Int): Int = if (n == 0) 0 else 1 + same(n - 1)
fun same(s: String): String = if (s.isEmpty()) "" else s[0].toString() + same(s.drop(1))

fun slen(s: String): Int {
    if (s.isEmpty())
        return 0
    return 1 + slen(s.drop(1))
}

fun reverse(s: String): String {
    if (s.isEmpty())
        return ""
    return s[s.lastIndex].toString() + reverse(s.dropLast(1))
}

fun chirp(n: Int): String =
        when {
            n < 1 -> "croak"
            n == 1 -> "chirp"
            else -> "chirp-" + chirp(n - 1)
        }

fun main(args: Array<String>) {
    println(same(5))
    println(same("abcde"))

    println(slen(""))
    println(slen("a"))
    println(slen("asdf"))

    println(reverse(""))
    println(reverse("reverse"))

    println(chirp(1))
    println(chirp(3))
    println(chirp(0))
}