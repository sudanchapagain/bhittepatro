package np.com.sudanchapagain.bhittepatro

import np.com.sudanchapagain.bhittepatro.bikramSambat.BikramSambat
import np.com.sudanchapagain.bhittepatro.data.EventsRepository.holidaysFor
import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class CalendarLogicTest {
    @Test
    fun testGetNepaliDateAndRoundTrip() {
        val bs = BikramSambat()
        val today = LocalDate.of(2024, 9, 1)
        val bsString = bs.getNepaliDate(today)
        val engBack = bs.getEnglishDateFromBs(bsString)
        assertEquals(today, engBack)
    }

    @Test
    fun testMonthDaysAndOffsetRange() {
        val bs = BikramSambat()
        val (days, offset) = bs.getMonthDaysWithOffset(2082, 0)
        assertTrue(days.isNotEmpty())
        assertTrue(offset in 0..6)
    }

    @Test
    fun testHolidaysForPinnedYear() {
        assertTrue(holidaysFor(2081, 0).isEmpty())
        val set = holidaysFor(2082, 0)
        assertTrue(set.contains(1))
    }
}
