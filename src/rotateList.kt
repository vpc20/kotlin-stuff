fun main(args: Array<String>) {
    val array1 = arrayOf(1, 2, 3)
    println(array1.toList().rotate(0))
    println(array1.toList().rotate(1))
    println(array1.toList().rotate(2))
    println(array1.toList().rotate(3))
    println(array1.toList().rotate(4))
    println(array1.toList().rotate(5))
    println("")
    println(array1.toList().rotate(0))
    println(array1.toList().rotate(-1))
    println(array1.toList().rotate(-2))
    println(array1.toList().rotate(-3))
    println(array1.toList().rotate(-4))
    println(array1.toList().rotate(-5))

//    array1.toList().rotate(-5).toTypedArray().forEach { print("$it ") }
//    println(array1.toList().rotate(-5).toTypedArray().javaClass)
}

fun <T> List<T>.rotate(n: Int): List<T> {
    val arrSize = this.size
    var r = n % arrSize
    if (r < 0)  // negative values means rotate left
        r += arrSize
    return if (r == 0) this else this.subList(arrSize - r, arrSize) + this.subList(0, arrSize - r)
}