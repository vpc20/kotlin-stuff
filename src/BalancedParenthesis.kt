fun balancedParenthesis(s: String): Boolean {
    val stack = mutableListOf<Char>()
    for (ch in s)
        if (ch == '(')
            stack.add(ch)
        else
            if (ch == ')')
                if (stack.isNotEmpty() && stack.last() == '(')
                    stack.removeAt(stack.lastIndex)
                else
                    return false
    return stack.isEmpty()
}

fun main(args: Array<String>) {
    println(balancedParenthesis("("))
    println(balancedParenthesis("(("))
    println(balancedParenthesis(")"))
    println(balancedParenthesis("))"))
    println(balancedParenthesis(")("))
    println(balancedParenthesis("()("))
    println(balancedParenthesis(")()"))
    println("")
    println(balancedParenthesis(""))
    println(balancedParenthesis(" "))
    println(balancedParenthesis("abc"))
    println(balancedParenthesis("()"))
    println(balancedParenthesis("(())"))
    println(balancedParenthesis("((()))"))
    println(balancedParenthesis("()()"))
    println(balancedParenthesis("()()()"))
    println(balancedParenthesis("()(())()"))
}