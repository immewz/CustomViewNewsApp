package com.mewz.customviewnewsapp.mvp.views

import com.mewz.customviewnewsapp.data.vos.NewsVO

interface MainView: BaseView {
    fun displayNewsList(newsList: List<NewsVO>)
    fun navigateToNewsDetails(newsId: Int)
    fun displayEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}