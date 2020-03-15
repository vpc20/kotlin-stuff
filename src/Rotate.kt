fun String.rotate(n: Int): String {
    if (this == "" || n == 0)
        return this

    var r = n % this.length
    if (r < 0)   // negative values means rotate left
        r += this.length

    return if (r == 0) this else this.substring(this.length - r, this.length) + this.substring(0, this.length - r)
}

fun main(args: Array<String>) {
//    println(rotate("", 0   ) )
//    println(rotate("", 1   ) )
//    println(rotate("abc", 0) )
//    println(rotate("abc", 1) )
//    println(rotate("abc", 2) )
//    println(rotate("abc", 3) )
//    println(rotate("abc", 4) )
//    println(rotate("abc", -1))
//    println(rotate("abc", -2))
//    println(rotate("abc", -3))
//    println(rotate("abc", -4))

    println("".rotate(0))
}