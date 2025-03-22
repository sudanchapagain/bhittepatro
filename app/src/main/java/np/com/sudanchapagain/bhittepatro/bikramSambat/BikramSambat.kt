package np.com.sudanchapagain.bhittepatro.bikramSambat

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

class BikramSambat {
    private val bsData: List<List<Int>> = listOf(
        listOf(2000, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2001, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2002, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2003, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2004, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2005, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2006, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2007, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2008, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31),
        listOf(2009, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2010, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2011, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2012, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30),
        listOf(2013, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2014, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2015, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2016, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30),
        listOf(2017, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2018, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2019, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2020, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2021, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2022, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30),
        listOf(2023, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2024, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2025, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2026, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2027, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2028, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2029, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30),
        listOf(2030, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2031, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2032, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2033, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2034, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2035, 30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31),
        listOf(2036, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2037, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2038, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2039, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30),
        listOf(2040, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2041, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2042, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2043, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30),
        listOf(2044, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2045, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2046, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2047, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2048, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2049, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30),
        listOf(2050, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2051, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2052, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2053, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30),
        listOf(2054, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2055, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2056, 31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30),
        listOf(2057, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2058, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2059, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2060, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2061, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2062, 30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31),
        listOf(2063, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2064, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2065, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2066, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31),
        listOf(2067, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2068, 31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2069, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2070, 31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30),
        listOf(2071, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2072, 31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30),
        listOf(2073, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31),
        listOf(2074, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2075, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2076, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30),
        listOf(2077, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2078, 31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2079, 31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30),
        listOf(2080, 31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30),
        listOf(2081, 31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31),
        listOf(2082, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30),
        listOf(2083, 31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30),
        listOf(2084, 31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30),
        listOf(2085, 31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30),
        listOf(2086, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30),
        listOf(2087, 31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30),
        listOf(2088, 30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30),
        listOf(2089, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30),
        listOf(2090, 30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30),
    )

    private val nepaliMonths: List<String> = listOf(
        "Baishak",
        "Jestha",
        "Ashad",
        "Shrawn",
        "Bhadra",
        "Ashwin",
        "Kartik",
        "Mangshir",
        "Poush",
        "Magh",
        "Falgun",
        "Chaitra"
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private val englishStartDate = LocalDate.of(1943, 4, 14)
    private val nepaliStartDate = Triple(2000, 1, 1)

    @RequiresApi(Build.VERSION_CODES.O)
    fun getNepaliDate(engDate: LocalDate): String {
        var totalEngDays = 0
        var currentEngDate = englishStartDate

        while (currentEngDate.isBefore(engDate)) {
            currentEngDate = currentEngDate.plusDays(1)
            totalEngDays++
        }

        var (nepYear, nepMonth, nepDay) = nepaliStartDate

        while (totalEngDays > 0) {
            val yearData = bsData.find { it[0] == nepYear } ?: break
            val daysInNepMonth = yearData[nepMonth]

            nepDay++
            totalEngDays--

            if (nepDay > daysInNepMonth) {
                nepMonth++
                nepDay = 1
            }
            if (nepMonth > 12) {
                nepYear++
                nepMonth = 1
            }
        }

        return "$nepDay ${nepaliMonths[nepMonth - 1]}, $nepYear"
    }

    fun getNepaliMonthName(monthIndex: Int): String {
        return nepaliMonths[monthIndex]
    }

    fun getYearMonthFromBsString(bsDate: String): Pair<Int, Int> {
        val parts = bsDate.split(" ")
        val monthName = parts[1].replace(",", "").trim()
        val year = parts[2].toInt()

        val monthIndex = nepaliMonths.indexOf(monthName)
        return Pair(year, monthIndex)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthDaysWithOffset(year: Int, monthIndex: Int): Pair<List<Int>, Int> {
        val yearData = bsData.find { it[0] == year } ?: return Pair(emptyList(), 0)
        val daysInMonth = yearData[monthIndex + 1]

        val firstDayOfMonthBs = "1 ${nepaliMonths[monthIndex]}, $year"
        val firstDayWeekIndex = getWeekdayOfBsDate(firstDayOfMonthBs)

        val days = mutableListOf<Int>()
        for (i in 1..daysInMonth) days.add(i)
        return Pair(days, firstDayWeekIndex)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getEnglishDateFromBs(bsDate: String): LocalDate {
        val parts = bsDate.split(" ")
        println(parts)
        if (parts.size != 3) throw IllegalArgumentException("Invalid BS date format")

        val day = parts[0].toInt()
        val monthName = parts[1].replace(",", "").trim()
        val year = parts[2].toInt()

        val monthIndex = nepaliMonths.indexOf(monthName) + 1
        if (monthIndex == 0) throw IllegalArgumentException("Invalid Nepali month name")

        var totalBsDays = 0
        for (y in nepaliStartDate.first until year) {
            val yearData = bsData.find { it[0] == y } ?: continue
            totalBsDays += yearData.subList(1, 13).sum()
        }

        for (m in 1 until monthIndex) {
            val yearData = bsData.find { it[0] == year } ?: throw IllegalArgumentException("Year not found")
            totalBsDays += yearData[m]
        }

        totalBsDays += day - 1

        return englishStartDate.plusDays(totalBsDays.toLong())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeekdayOfBsDate(bsDate: String): Int {
        val engDate = getEnglishDateFromBs(bsDate)
        return engDate.dayOfWeek.value % 7
    }
}
