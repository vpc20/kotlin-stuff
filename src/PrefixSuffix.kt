fun main(args: Array<String>) {
    val s = "abcdefg"
    println(s.prefixes())
    println(s.properPrefixes())
    println(s.suffixes())
    println(s.properSuffixes())

    val s1 = "prefetch"
    val s2 = "prefix"
    println(lcp(s1, s2)) // longest common prefix
    println(lcpLen(s1, s2)) // longest common prefix
    println("abcfdsdfabcfs".lrs()) // longest repeated substring
}


fun String.prefixes() = (0..this.lastIndex).map { this.slice(0..it) }
fun String.properPrefixes() = (0..this.lastIndex - 1).map { this.slice(0..it) }

fun String.suffixes() = (0..this.lastIndex).map { this.slice(it..this.lastIndex) }
fun String.properSuffixes() = (1..this.lastIndex).map { this.slice(it..this.lastIndex) }

fun lcp(s1: String, s2: String) =
        (0..minOf(s1.lastIndex, s2.lastIndex))
                .firstOrNull { s1.slice(0..it) != s2.slice(0..it) }
                ?.let { s1.slice(0..it - 1) }
                ?: ""

//fun lcp(s1: String, s2: String): String {
//    val endPos = (0..minOf(s1.lastIndex, s2.lastIndex))
//            .firstOrNull { s1.slice(0..it) != s2.slice(0..it) }
//            ?.let { it - 1 }
//            ?: -1
//    return s1.slice(0..endPos)
//}

//fun lcp(s1: String, s2: String): String {
//    var endPos = 0
//    for (i in 0..minOf(s1.lastIndex, s2.lastIndex))
//        if (s1.slice(0..i) != s2.slice(0..i)) {
//            endPos = i - 1
//            break
//        }
//    return s1.slice(0..endPos)
//}

fun lcpLen(s1: String, s2: String) =
        (0..minOf(s1.lastIndex, s2.lastIndex)).firstOrNull { s1[it] != s2[it] } ?: 0

fun String.lrs(): String? {
    val suffArr = this.suffixes().sorted()
    return (0..suffArr.lastIndex - 1)
            .map { lcp(suffArr[it], suffArr[it + 1]) }
            .maxBy { it.length } ?: ""
}

//fun String.lrs(): String {
//    var lrs = ""
//    val suffArr = this.suffixes().sorted()
//    (0..suffArr.lastIndex - 1)
//            .asSequence()
//            .map { lcp(suffArr[it], suffArr[it + 1]) }
//            .filter { it.length > lrs.length }
//            .forEach { lrs = it }
//    return lrs
//}

//fun String.lrs(): String {
//    var lrs = ""
//    val suffArr = this.suffixes().sorted()
//    for (i in 0..suffArr.lastIndex - 1) {
//        val lcp = lcp(suffArr[i], suffArr[i + 1])
//        if (lcp.length > lrs.length)
//            lrs = lcp
//    }
//    return lrs
//}
