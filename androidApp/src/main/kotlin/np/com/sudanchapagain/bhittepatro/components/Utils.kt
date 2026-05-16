package np.com.sudanchapagain.bhittepatro.components

fun fuzzyMatch(text: String, query: String): Boolean {
    return fuzzyScore(text, query) > 0
}

fun fuzzyScore(text: String, query: String): Int {
    val t = text.lowercase()
    val q = query.lowercase()
    if (q.isBlank()) return 0
    if (t.contains(q)) return q.length * 10
    var ti = 0
    var qi = 0
    var score = 0
    while (ti < t.length && qi < q.length) {
        if (t[ti] == q[qi]) {
            score += 2
            qi++
        }
        ti++
    }
    if (t.isNotEmpty() && q.isNotEmpty() && t[0] == q[0]) score += 1
    return score
}
