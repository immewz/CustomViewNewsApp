package com.mewz.customviewnewsapp.delegates

import com.mewz.customviewnewsapp.views.viewpods.ReactionViewPod

interface NewsItemDelegate: ReactionViewPod.Delegate{
    fun onTapNewsItem(newsId: Int)
}