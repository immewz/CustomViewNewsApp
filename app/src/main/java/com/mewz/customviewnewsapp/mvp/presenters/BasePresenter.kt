package com.mewz.customviewnewsapp.mvp.presenters

import com.mewz.customviewnewsapp.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view: T)
}