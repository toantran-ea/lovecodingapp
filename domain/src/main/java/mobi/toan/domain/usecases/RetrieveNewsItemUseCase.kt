package mobi.toan.domain.usecases

import io.reactivex.Observable
import mobi.toan.domain.dao.NewsRepo
import mobi.toan.domain.entity.NewsItem

interface RetrieveNewsItemUseCase {
    fun execute(): Observable<List<NewsItem>>
}

class RetrieveNewsItemUseCaseImpl(private val repo: NewsRepo) : RetrieveNewsItemUseCase {
    override fun execute(): Observable<List<NewsItem>> {
        return repo.getAllNewsItem()
    }
}
