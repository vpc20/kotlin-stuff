fun main(args: Array<String>) {
    println("x, y , z".replaceLast(",", "and"))
}

private fun String.replaceLast(s1: String, s2: String): String {
    val idx1 = this.indexOfLast { it.toString() == s1 }
    if (idx1 == -1)
        return ""
    else
        return this.substring(0, idx1) + this.substring(idx1, this.length).replace(s1, s2)
}
