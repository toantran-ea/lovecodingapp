package mobi.toan.domain.usecases

import io.reactivex.Completable
import mobi.toan.domain.dao.NewsRepo
import mobi.toan.domain.entity.NewsItem

interface BookmarkNewsUseCase {
    fun execute(newsItem: NewsItem): Completable
}

class BookmarkNewsUseCaseImpl(private val newsRepo: NewsRepo) : BookmarkNewsUseCase {
    override fun execute(newsItem: NewsItem): Completable {
        return newsRepo.bookmarkLocally(newsItem)
            .concatWith { newsRepo.addRemoteBookmark(newsItem) }
    }
}
