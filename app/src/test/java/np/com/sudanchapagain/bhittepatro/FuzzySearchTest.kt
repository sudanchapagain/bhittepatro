package np.com.sudanchapagain.bhittepatro

import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

class FuzzySearchTest {
    @Test
    fun exactMatchBeatsSubsequence() {
        val exact = invokeScore("Dashain Festival", "Dashain")
        val subseq = invokeScore("Dashain Festival", "Dsn")
        assertTrue(exact > subseq)
    }

    @Test
    fun fuzzyMatchesCommonAbbrev() {
        assertTrue(invokeMatch("Maha Shivaratri", "mhsr"))
        assertTrue(invokeMatch("Gai Jatra", "gj"))
        assertFalse(invokeMatch("Gai Jatra", "zzzz"))
    }

    private fun invokeScore(text: String, query: String): Int {
        val method = Class.forName("np.com.sudanchapagain.bhittepatro.components.CalendarKt")
            .getDeclaredMethod("fuzzyScore", String::class.java, String::class.java)
        method.isAccessible = true
        return method.invoke(null, text, query) as Int
    }

    private fun invokeMatch(text: String, query: String): Boolean {
        val method = Class.forName("np.com.sudanchapagain.bhittepatro.components.CalendarKt")
            .getDeclaredMethod("fuzzyMatch", String::class.java, String::class.java)
        method.isAccessible = true
        return method.invoke(null, text, query) as Boolean
    }
}
