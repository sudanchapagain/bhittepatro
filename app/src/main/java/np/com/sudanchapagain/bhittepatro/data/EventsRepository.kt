package np.com.sudanchapagain.bhittepatro.data

import np.com.sudanchapagain.bhittepatro.model.EventEntry
import np.com.sudanchapagain.bhittepatro.model.eventsByMonth

object EventsRepository {
    const val SUPPORTED_YEAR = 2082

    val eventsByMonth2082: Map<Int, List<EventEntry>>
        get() = eventsByMonth

    fun holidaysFor(year: Int, monthIndex: Int): Set<Int> {
        if (year != SUPPORTED_YEAR) return emptySet()
        val list = eventsByMonth2082[monthIndex + 1] ?: return emptySet()
        return list.filter { it.holiday }.mapNotNull {
            it.bs.split("-").lastOrNull()?.toIntOrNull()
        }.toSet()
    }
}
