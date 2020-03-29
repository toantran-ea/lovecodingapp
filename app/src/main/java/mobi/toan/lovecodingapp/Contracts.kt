package mobi.toan.lovecodingapp

import mobi.toan.domain.entity.NewsItem

interface View {
    fun bindNewsList(newsItems: List<NewsItem>)
}

interface Presenter {
    fun presentNewsList()

    fun destroy()

    fun attachView(view: View)
}

