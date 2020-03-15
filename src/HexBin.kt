fun hex2Dec(s: String): Int {
    val hexDigits = "0123456789ABCDEF"
    val s1 = s.toUpperCase()
    val slastIndex = s.lastIndex

    if (s1.any { !(hexDigits.contains(it)) })
        throw RuntimeException("Invalid hex number")

    return s1.indices.sumBy {
        hexDigits.indexOf(s1[it]) * (Math.pow(16.0, (slastIndex - it).toDouble())).toInt()
    }

}

fun bin2Dec(s: String) = s.indices.sumBy { "01".indexOf(s[it].toUpperCase()) * (Math.pow(2.0, (s.lastIndex - it).toDouble())).toInt() }

//    val hexDigits = "0123456789ABCDEF"
//    for (i in s.indices) {
//        dec += hexDigits.indexOf(s[i].toUpperCase()) * (Math.pow(16.0, (s.lastIndex - i).toDouble())).toInt()
//    }


fun main(args: Array<String>) {

    val hex = 0xffff
    val bin = 0b11111111
    println("hex = $hex is an ${hex.javaClass}")
    println("bin = $bin is an ${bin.javaClass}")

    val x = "\u2202"
    println("$x is a ${x.javaClass.toString().takeLastWhile { it != '.' }} of length ${x.length}")

    println(hex2Dec("ffff"))
    println(Integer.toBinaryString(hex2Dec("2202")))
    println(bin2Dec("1111"))
    println(Integer.toHexString(255))

}
