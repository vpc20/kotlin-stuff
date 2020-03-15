fun String.translate(oldChars: String, newChars: String): String {
    val transtab = mutableMapOf<Char, Char>()
    var outs: String = ""
    for (i in 0..oldChars.lastIndex)
        transtab[oldChars[i]] = newChars[i]
    for (i in this)
        outs += if (i in transtab) transtab[i] else i
    return outs
}

private fun String.translate1(oldChars: String, newChars: String): String {
    val transtab = mutableMapOf<Char, Char>()
    var outs: String = ""
    (0..oldChars.lastIndex).forEach { transtab[oldChars[it]] = newChars[it] }
    this.forEach { outs += if (it in transtab) transtab[it] else it }
    return outs
}

private fun String.translate2(oldChars: String, newChars: String): String {
    val transtab = mutableMapOf<Char, Char>()
    (0..oldChars.lastIndex).forEach { transtab[oldChars[it]] = newChars[it] }
    return this.map { if (it in transtab) transtab[it] else it }.joinToString("")
}

private fun String.translate3(oldChars: String, newChars: String): String {
//    val transtab = (0..oldChars.lastIndex).map { oldChars[it] to newChars[it] }.toMap()
//    val transtab = (0..oldChars.lastIndex).associate { Pair(oldChars[it], newChars[it]) }
//    val transtab = (0..oldChars.lastIndex).associate { oldChars[it] to newChars[it] }
    val transtab = oldChars.indices.associate { oldChars[it] to newChars[it] }
    return this.map { if (it in transtab) transtab[it] else it }.joinToString("")
}

fun main(args: Array<String>) {
    println("abcdef;".translate("abc", "xyz"))
    println("abcdef;".translate1("abc", "xyz"))
    println("abcdef;".translate2("abc", "xyz"))
    println("abcdef;".translate3("abc", "xyz"))
}
