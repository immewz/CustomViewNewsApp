package com.mewz.customviewnewsapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mewz.customviewnewsapp.delegates.NewsItemDelegate
import com.mewz.customviewnewsapp.mvp.views.MainView
import com.mewz.customviewnewsapp.views.viewpods.EmptyViewPod

interface MainPresenter: NewsItemDelegate, BasePresenter<MainView>, EmptyViewPod.Delegate {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}