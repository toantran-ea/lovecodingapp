package mobi.toan.lovecodingapp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import mobi.toan.domain.usecases.RetrieveNewsItemUseCase

class MainPresenter(
    private val usecase: RetrieveNewsItemUseCase,
    private val scheduleProvider: ScheduleProvider
) : Presenter {
    private lateinit var screen: View
    private val disposables by lazy { CompositeDisposable() }

    override fun presentNewsList() {
        usecase.execute()
            .subscribeOn(scheduleProvider.provideIO())
            .observeOn(scheduleProvider.provideMain())
            .subscribe({
                screen.bindNewsList(it)
            }, {
                it.printStackTrace()
            }).addTo(disposables)
    }

    override fun destroy() {
        disposables.dispose()
    }

    override fun attachView(view: View) {
        screen = view
    }
}
