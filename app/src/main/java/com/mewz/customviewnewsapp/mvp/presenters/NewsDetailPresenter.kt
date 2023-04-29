package com.mewz.customviewnewsapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mewz.customviewnewsapp.mvp.views.NewsDetailView

interface NewsDetailPresenter: BasePresenter<NewsDetailView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, newsId : Int)
}