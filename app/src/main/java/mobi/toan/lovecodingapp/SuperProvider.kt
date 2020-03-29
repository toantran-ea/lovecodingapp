package mobi.toan.lovecodingapp

import mobi.toan.domain.dao.NewsRepo
import mobi.toan.domain.dao.NewsRepoImpl
import mobi.toan.domain.usecases.RetrieveNewsItemUseCase
import mobi.toan.domain.usecases.RetrieveNewsItemUseCaseImpl

object SuperProvider {
    fun providePresenter(): Presenter {
        return MainPresenter(provideGetAllNewsUseCase(), schedulerProvider())
    }

    // region internal providers
    private fun provideGetAllNewsUseCase(): RetrieveNewsItemUseCase {
        return RetrieveNewsItemUseCaseImpl(provideNewsRepo())
    }

    private fun provideNewsRepo(): NewsRepo {
        return NewsRepoImpl()
    }

    private fun schedulerProvider(): ScheduleProvider {
        return ScheduleProviderImpl()
    }
    // endregion
}
