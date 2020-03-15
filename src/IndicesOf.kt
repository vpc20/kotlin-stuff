fun main(args: Array<String>) {
    val s = "aaa"
    println(s.indicesOf("a",2))
}

fun CharSequence.indicesOf(s: String, startIndex: Int = 0, ignoreCase: Boolean = false): List<Int> {
    val indicesList = mutableListOf<Int>()
    var currIndex = startIndex
    var pos = 0

    while (pos != -1 && currIndex < this.length) {
        pos = this.indexOf(s, currIndex, ignoreCase)
        if (pos != -1) {
            indicesList.add(pos)
            currIndex = pos + 1
        }
    }
    return indicesList
}