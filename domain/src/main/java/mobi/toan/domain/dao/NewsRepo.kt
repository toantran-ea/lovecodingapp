package mobi.toan.domain.dao

import io.reactivex.Completable
import io.reactivex.Observable
import mobi.toan.domain.entity.NewsItem

interface NewsRepo {
    fun getAllNewsItem(): Observable<List<NewsItem>>
    fun bookmarkLocally(newsItem: NewsItem): Completable
    fun addRemoteBookmark(newsItem: NewsItem): Completable
}

class NewsRepoImpl() : NewsRepo {
    override fun getAllNewsItem(): Observable<List<NewsItem>> {
        return Observable.just(
            listOf(
                NewsItem(
                    "id1",
                    "Github is free!!!",
                    description = "Finally, MS makes Github free with private repos",
                    publishedTime = 1585387760
                )
            )
        )
    }

    override fun bookmarkLocally(newsItem: NewsItem): Completable {
        // update local database
        return Completable.complete()
    }

    override fun addRemoteBookmark(newsItem: NewsItem): Completable {
        // call api
        return Completable.complete()
    }
}
