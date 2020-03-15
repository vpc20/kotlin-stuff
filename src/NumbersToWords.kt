fun main(args: Array<String>) {
//    for (i in 1..100)
//        println(n2w(i))
//    println(n2w(1))
    for (i in 1..1000)
        println(numberToWords(i))
}

fun numberToWords(n: Int): String {
    val n2wThousands = listOf(
            Pair(Math.pow(10.0, 24.0), "septillion"), Pair(Math.pow(10.0, 21.0), "sextillion"),
            Pair(Math.pow(10.0, 18.0), "quintillion"), Pair(Math.pow(10.0, 15.0), "quadrillion"),
            Pair(Math.pow(10.0, 12.0), "trillion"), Pair(Math.pow(10.0, 9.0), "billion"),
            Pair(Math.pow(10.0, 6.0), "million"), Pair(Math.pow(10.0, 3.0), "thousand")
    )
    var result = ""
    var q: Double = 0.0
    var r = n.toDouble()

    for ((value, word) in n2wThousands) {
        q = r.div(value)
        r = r.rem(value)
        if (q.toInt() > 0)
            result += n2w(q.toInt()) + " " + word + " "
    }
    result += n2w(r.toInt())
    return result.trim()
}

fun n2w(n: Int): String {
    val n2wMap = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five",
            6 to "six", 7 to "seven", 8 to "eight", 9 to "nine", 10 to "ten",
            11 to "eleven", 12 to "twelve", 13 to "thirteen", 14 to "fourteen", 15 to "fifteen",
            16 to "sixteen", 17 to "seventeen", 18 to "eighteen", 19 to "nineteen",
            20 to "twenty", 30 to "thirty", 40 to "forty", 50 to "fifty",
            60 to "sixty", 70 to "seventy", 80 to "eighty", 90 to "ninety")

    var numInWord = ""
    var q = n.div(100)
    var r = n.rem(100)
    if (q > 0)
        numInWord += n2wMap[q] + " hundred "

    if (r != 0) {
        if (r < 20 || r.rem(10) == 0)
            numInWord += n2wMap[r]
        else {
            q = r.div(10)
            r = r.rem(10)
            numInWord += n2wMap[q * 10] + " " + n2wMap[r]
        }
    }
    return numInWord.trim()
}
