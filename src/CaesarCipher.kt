//fun caesarCipher(s: String, n: Int): String {
//    val lowerAlphabet = "abcdefghijklmnopqrstuvwxyz"
//    val upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//
//    var caesar = ""
//    for (c in s)
//        when {
//            c in 'a'..'z' -> caesar += lowerAlphabet[lowerAlphabet.indexOf(c) + n % 26]
//            c in 'A'..'Z' -> caesar += upperAlphabet[upperAlphabet.indexOf(c) + n % 26]
//            else -> caesar += c
//        }
//    return caesar
//}

fun main(args: Array<String>) {
    println(caesarCipher("abcABC", 27))
    println(caesarCipher1("abcABC", 1))
}

fun caesarCipher(s: String, n: Int): String {
    val lowerAlphabet = "abcdefghijklmnopqrstuvwxyz"
    val upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    if (s.isEmpty())
        return ""

    return when {
        s[0] in 'a'..'z' -> lowerAlphabet[lowerAlphabet.indexOf(s[0]) + n % 26]
        s[0] in 'A'..'Z' -> upperAlphabet[upperAlphabet.indexOf(s[0]) + n % 26]
        else -> s[0]
    } + caesarCipher(s.drop(1), n)
}

fun caesarCipher1(s: String, i: Int): String {
    val lowerAlphabet = "abcdefghijklmnopqrstuvwxyz"
    val upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val r = i % 26
    return s.translate(lowerAlphabet + upperAlphabet, lowerAlphabet.rotate(r) + upperAlphabet.rotate(r))
}

//private fun String.rotate(n: Int): String {
//    if (this == "" || n == 0)
//        return this
//
//    var r = n % this.length
//    if (r < 0)   // negative values means rotate left
//        r += this.length
//
//    return if (r == 0) this else this.substring(this.length - r, this.length) + this.substring(0, this.length - r)
//}
//
//
//private fun String.translate(oldChars: String, newChars: String): String {
//    val transtab = (0..oldChars.lastIndex).associate { oldChars[it] to newChars[it] }
//    return this.map { if (it in transtab) transtab[it] else it }.joinToString("")
//}

//private fun lowerAlphabet(): String {
//    return ('a'..'z').map {it}.joinToString("")
//}
//
//private fun lowerAlphabet(): String {
//    var s = ""
//    ('a'..'z').forEach { ch -> s += ch }
//    return s
//}
//
//private fun lowerAlphabet1(): String {
//    var s = ""
//    for (ch in 'a'..'z')
//        s += ch
//    return s
//}