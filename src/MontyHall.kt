import java.util.*

fun main(args: Array<String>) {
    var winCount = 0
    for (i in 0..100000)
        if (montyHall())  // switch is set to true, change to false if you want to stay
            winCount += 1
    println(winCount)
}

//private fun montyHallTrials(n: Int): Int {
//    if (n == 0)
//        return 0
//    if (montyHall(true))
//        return 1 + montyHallTrials(n-1)
//    else
//        return montyHallTrials(n-1)
//}

// returns true if it is a win; default switch to true
private fun montyHall(switch: Boolean = true): Boolean {
    val choices = listOf("car", "goat", "goat")
    if (choices[Random().nextInt(3)] == "goat")
        return switch
    else
        return !switch
}

//private fun MontyHallOneLiner(switch: Boolean = true) = if (listOf("car", "goat", "goat")[Random().nextInt(3)] == "goat") switch else !switch