fun isAnagram(s1: String, s2: String): Boolean =
        s1.toCharArray().sorted() == s2.toCharArray().sorted()

fun main(args: Array<String>) {
    println(isAnagram("abc", "cba"))
    println(isAnagram("", ""))
    println(isAnagram("abc", "abd"))
}

