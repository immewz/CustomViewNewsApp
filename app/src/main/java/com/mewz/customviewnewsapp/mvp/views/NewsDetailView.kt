package com.mewz.customviewnewsapp.mvp.views

import com.mewz.customviewnewsapp.data.vos.NewsVO

interface NewsDetailView: BaseView {
    fun displayNewsDetail(news: NewsVO)
}