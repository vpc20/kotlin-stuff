class FiniteStateMachine {
    var initialState: String = ""
    val acceptingStatesSet = mutableSetOf<String>()
    val edgesMap = mutableMapOf<Pair<String, String>, String>()

    fun addInitialState(state: String) {
        initialState = state
    }

    fun addAcceptingStates(vararg states: String) {
        acceptingStatesSet += states
    }

    fun addEdge(startState: String, s: String, endState: String) {
        edgesMap[Pair(startState, s)] = endState
    }

    fun run(s: String): Boolean {
        var currState = initialState
        for (ch in s)
            if (Pair(currState, ch.toString()) in edgesMap)
                currState = edgesMap[Pair(currState, ch.toString())] as String
            else
                return false
        return (currState in acceptingStatesSet)
    }
}

fun main(args: Array<String>) {
    val fsm = FiniteStateMachine()

    fsm.addInitialState("s1")
    println(fsm.initialState)

    fsm.addAcceptingStates("s1", "s2")
    fsm.addAcceptingStates("s3")
    println(fsm.acceptingStatesSet)

    fsm.addEdge("s1", "1", "s2")
    fsm.addEdge("s2", "1", "s1")
    println(fsm.edgesMap)

    println(fsm.run("x"))

}