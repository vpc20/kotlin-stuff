//    fun factorial(n: Int): Int {
//        if (n == 0 || n == 1)
//            return 1
//        else
//            return n * factorial(n - 1)
//    }

//    fun factorial(n: Int): Int =
//            if (n == 0 || n == 1) 1 else n * factorial(n - 1)

//fun factorial(n: Int): Int =
//        if (n == 0) 1 else (1..n).reduce { x, y -> x * y }

fun factorial(n: Int): Double {
    var result: Double = 1.0
    (1..n).forEach { result *= it }
    return result

}

fun main(args: Array<String>) {
    println(factorial(0))
    println(factorial(1))
    println(factorial(2))
    println(factorial(3))
    println(factorial(4))
    println(factorial(5))
    println(factorial(170))
}
