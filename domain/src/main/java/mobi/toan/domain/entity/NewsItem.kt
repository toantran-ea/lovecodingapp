package mobi.toan.domain.entity

import kotlin.math.abs

data class NewsItem(
    val id: String, val title: String, val description: String,
    val publishedTime: Long
) {
    fun isOutdated(time: Long): Boolean {
        return abs(time - publishedTime) >= OUTDATED_PERIOD
    }

    companion object {
        const val OUTDATED_PERIOD = 7 * 24 * 60 * 60 * 1000
    }
}
