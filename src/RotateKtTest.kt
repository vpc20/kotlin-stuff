import org.junit.Assert.*

class RotateKtTest {
    @org.junit.Test
    fun rotatetest() {
        assertEquals("", "".rotate(0))
        assertEquals("", "".rotate(1))
        assertEquals("abc", "abc".rotate(0))
        assertEquals("cab", "abc".rotate(1))
        assertEquals("bca", "abc".rotate(2))
        assertEquals("abc", "abc".rotate(3))
        assertEquals("cab", "abc".rotate(4))
        assertEquals("bca", "abc".rotate(5))
        assertEquals("abc", "abc".rotate(6))
        assertEquals("bca", "abc".rotate(-1))
        assertEquals("cab", "abc".rotate(-2))
        assertEquals("abc", "abc".rotate(-3))
        assertEquals("bca", "abc".rotate(-4))
        assertEquals("cab", "abc".rotate(-5))
        assertEquals("abc", "abc".rotate(-6))
    }

}

