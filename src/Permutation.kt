//import kotlin.coroutines.experimental.buildIterator

fun main(args: Array<String>) {

    println(permutation("abc", 1).toList())
    println(permutation1("abc", 1).toList())
    println(permutation("abc", 2).toList())
    println(permutation1("abc", 2).toList())

}

//fun permutation(suff: String, pref: String = ""): Iterator<String> = buildIterator {
//    if (suff.length == 1)
//        yield(pref + suff)
//    (0..suff.lastIndex)
//            .map { suff.slice(it..suff.lastIndex) + suff.slice(0..it - 1) }
//            .forEach { yieldAll(permutation(it.slice(1..it.lastIndex), pref + it[0])) }
//}
//
//fun permutation1(s: String): Iterator<String> = buildIterator {
//    if (s.length < 2)
//        yield(s)
//    else {
//        for (i in 0..s.lastIndex)
//            for (p in permutation1(s.slice(0..i - 1) + s.slice(i + 1..s.lastIndex)))
//                yield(s[i] + p)
//    }
//}

fun permutation(s: String, r: Int): Sequence<String> = sequence {
    if (r == 1)
        for (c in s)
            yield(c.toString())
    else
        for ((i, e) in s.withIndex())
            for (p in permutation(s.substring(0, i) + s.substring(i, s.lastIndex), r - 1))
                yield(e + p)
}

fun permutation1(s: String, r: Int): Sequence<String> = sequence {
    if (r == 1)
        s.forEach { yield(it.toString()) }
    else
        s.withIndex().forEach { (i, e) ->
            permutation(s.substring(0, i) + s.substring(i, s.lastIndex), r - 1).forEach {
                yield(e + it)
            }
        }
}

//fun permutation1(s: String, r: Int): Sequence<String> = sequence {
//    if (r == 1)
//        s.forEach { yield(it) }
//    else
//        s.forEachIndexed { i, e ->
//            permutation(s.substring(0, i) + s.substring(i, s.lastIndex), r - 1).forEach {
//                yield(e + it)
//            }
//        }
//}
