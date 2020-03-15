//fun fibonacci(n: Int) : Int{
//    var curr: Int = 0
//    var next: Int = 1
//    var tmpcurr: Int = 0
//
//    for (i in 0..n - 2) {
//        tmpcurr = curr
//        curr = next
//        next = curr + tmpcurr
//    }
//    return curr
//}

//fun fibonacci(n: Int): Int {
//    var curr: Int = 0
//    var next: Int = 1
//    var tmpcurr: Int
//    for (it in 0..n - 2) {
//        tmpcurr = curr
//        curr = next
//        next = curr + tmpcurr
//    }
//    return curr
//}

fun fibonacci(n: Int): Int =
        when (n) {
            0, 1 -> 0
            2 -> 1
            else -> fibonacci(n - 1) + fibonacci(n - 2)
        }

fun main(args: Array<String>) {
    println(fibonacci(1))
    println(fibonacci(2))
    println(fibonacci(3))
    println(fibonacci(4))
    println(fibonacci(5))
}