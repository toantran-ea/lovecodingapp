package mobi.toan.lovecodingapp

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface ScheduleProvider {
    fun provideIO(): Scheduler

    fun provideMain(): Scheduler

    fun provideComputation(): Scheduler
}

class ScheduleProviderImpl : ScheduleProvider {
    override fun provideIO() = Schedulers.io()

    override fun provideMain(): Scheduler = AndroidSchedulers.mainThread()

    override fun provideComputation() = Schedulers.computation()
}
