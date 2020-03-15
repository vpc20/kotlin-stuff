open class LogicGate(val name: String)

open class UnaryGate(name: String) : LogicGate(name) {

    var input: Any? = null

    fun getInputx(): Int {
        when (input) {
            is Int ->
                if (input == 0 || input == 1)
                    return input as Int
                else
                    throw RuntimeException("Invalid input for UnaryGate $name")
            is OrGate -> return (input as OrGate).output()
            is AndGate -> return (input as AndGate).output()
            is Inverter -> return (input as Inverter).output()
            else -> throw RuntimeException("Invalid input for UnaryGate $name")
        }
    }
}


class Inverter(name: String) : UnaryGate(name) {
    fun output(): Int = if (getInputx() == 0) 1 else 0
}

open class BinaryGate(name: String) : LogicGate(name) {

    var input1: Any? = null
    var input2: Any? = null

    fun getInput1x(): Int {
        when (input1) {
            is Int ->
                if (input1 == 0 || input1 == 1)
                    return input1 as Int
                else
                    throw RuntimeException("Invalid input for BinaryGate $name")
            is OrGate -> return (input1 as OrGate).output()
            is AndGate -> return (input1 as AndGate).output()
            is Inverter -> return (input1 as Inverter).output()
            else -> throw RuntimeException("Invalid input for BinaryGate $name")
        }
    }

    fun getInput2x(): Int {
        when (input2) {
            is Int ->
                if (input2 == 0 || input2 == 1)
                    return input2 as Int
                else
                    throw RuntimeException("Invalid input for BinaryGate $name")
            is OrGate -> return (input2 as OrGate).output()
            is AndGate -> return (input2 as AndGate).output()
            is Inverter -> return (input2 as Inverter).output()
            else -> throw RuntimeException("Invalid input for BinaryGate $name")
        }
    }

//    fun getInput2x(): Int =
//            when (input2) {
//                is Int -> input2 as Int
//                is OrGate -> (input2 as OrGate).output()
//                is AndGate -> (input2 as AndGate).output()
//                is Inverter -> (input2 as Inverter).output()
//                else -> throw RuntimeException("Invalid input for BinaryGate")
//            }
}

class OrGate(name: String) : BinaryGate(name) {
    fun output(): Int = getInput1x() or getInput2x()
}

class AndGate(name: String) : BinaryGate(name) {
    fun output(): Int = getInput1x() and getInput2x()
}

class NorGate(name: String) : BinaryGate(name) {
    fun output(): Int {
        val or1 = OrGate("or1")
        val inv1 = Inverter("inv1")

        or1.input1 = input1
        or1.input2 = input2
        inv1.input = or1
        return inv1.output()
    }
}

class NandGate(name: String) : BinaryGate(name) {
    fun output(): Int {
        val and1 = AndGate("and1")
        val inv1 = Inverter("inv1")

        and1.input1 = input1
        and1.input2 = input2
        inv1.input = and1
        return inv1.output()
    }
}

class XorGate(name: String) : BinaryGate(name) {
    fun output(): Int {
        val and1 = AndGate("and1")
        val and2 = AndGate("and2")
        val or1 = OrGate("or1")
        val inv1 = Inverter("inv1")

        and1.input1 = input1
        and1.input2 = input2
        or1.input1 = input1
        or1.input2 = input2

        inv1.input = and1
        and2.input1 = inv1
        and2.input2 = or1
        return and2.output()
    }
}

class XnorGate(name: String) : BinaryGate(name) {
    fun output(): Int {
        val and1 = AndGate("and1")
        val and2 = AndGate("and2")
        val or1 = OrGate("or1")
        val inv1 = Inverter("inv1")
        val inv2 = Inverter("inv1")

        and1.input1 = input1
        and1.input2 = input2
        or1.input1 = input1
        or1.input2 = input2

        inv1.input = and1
        and2.input1 = inv1
        and2.input2 = or1
        inv2.input = and2
        return inv2.output()
    }
}


fun main(args: Array<String>) {
//    val or1 = OrGate()
//    or1.input1 = 0
//    or1.input2 = 0
//    val or2 = OrGate()
//    or2.input1 = 0
//    or2.input2 = 1
//    val or3 = OrGate()
//    or3.connector1 = or1
//    or3.connector2 = or2
//
//    println(or1.output())
//    println(or2.output())
//    println(or3.output())


//    println(or1.output())
//    println(or1.output())

    val inv1 = Inverter("inv1")
    for (i in 0..1) {
        inv1.input = i
        println("Not $i = ${inv1.output()}")
    }

    val and1 = AndGate("and1")
    for (i in 0..1)
        for (j in 0..1) {
            and1.input1 = i
            and1.input2 = j
            println("$i and $j = ${and1.output()}")
        }

    val or1 = OrGate("or1")
    for (i in 0..1)
        for (j in 0..1) {
            or1.input1 = i
            or1.input2 = j
            println("$i or $j = ${or1.output()}")
        }

    val nor1 = NorGate("nor1")
    for (i in 0..1)
        for (j in 0..1) {
            nor1.input1 = i
            nor1.input2 = j
            println("$i nor $j = ${nor1.output()}")
        }

    val nand1 = NandGate("nand1")
    for (i in 0..1)
        for (j in 0..1) {
            nand1.input1 = i
            nand1.input2 = j
            println("$i nand $j = ${nand1.output()}")
        }

    val xor1 = XorGate("xor1")
    for (i in 0..1)
        for (j in 0..1) {
            xor1.input1 = i
            xor1.input2 = j
            println("$i xor $j = ${xor1.output()}")
        }

    val xnor1 = XnorGate("xnor1")
    for (i in 0..1)
        for (j in 0..1) {
            xnor1.input1 = i
            xnor1.input2 = j
            println("$i xnor $j = ${xnor1.output()}")
        }
}
