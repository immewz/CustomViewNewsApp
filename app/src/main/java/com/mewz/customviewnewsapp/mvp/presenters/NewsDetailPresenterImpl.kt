package com.mewz.customviewnewsapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mewz.customviewnewsapp.mvp.views.NewsDetailView

class NewsDetailPresenterImpl: NewsDetailPresenter, AbstractBasePresenter<NewsDetailView>() {
    override fun onUiReady(lifeCycleOwner: LifecycleOwner, newsId: Int) {

    }
}
