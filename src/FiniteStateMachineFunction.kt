fun main(args: Array<String>) {
    val s = "1"
    val initialState = "s1"
    val acceptingStatesSet = mutableSetOf("s1", "s2")
    val edgesMap = mutableMapOf(
            Pair("s1", "1").to("s2"),
            Pair("s2", "1").to("s1"))

//    println(edgesMap[Pair("s1", "1")])
//    for ((k, v) in edgesMap)
//        println(v.javaClass)

    println(fsm(s, initialState, acceptingStatesSet, edgesMap))
}

private fun fsm(s: String, initialState: String,
                acceptingSatesSet: Set<String>,
                edgesMap: MutableMap<Pair<String, String>, String>): Boolean {
    var currState = initialState
    for (ch in s) {
        if (Pair(currState, ch.toString()) in edgesMap)
            currState = edgesMap[Pair(currState, ch.toString())] as String
        else
            return false
    }
    return (currState in acceptingSatesSet)
}