package com.mewz.customviewnewsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mewz.customviewnewsapp.R
import com.mewz.customviewnewsapp.data.vos.NewsVO
import com.mewz.customviewnewsapp.delegates.NewsItemDelegate
import com.mewz.customviewnewsapp.views.viewholders.BaseNewsViewHolder
import com.mewz.customviewnewsapp.views.viewholders.NewsSmallViewHolder
import com.mewz.customviewnewsapp.views.viewholders.NewsViewHolder

class NewsListAdapter(delegate: NewsItemDelegate): BaseRecyclerAdapter<BaseNewsViewHolder, NewsVO>() {

    val mDelegate: NewsItemDelegate = delegate
    val VIEW_TYPE_LARGE = 2244
    val VIEW_TYPE_SMALL = 1122

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseNewsViewHolder {
        when(viewType){
            VIEW_TYPE_LARGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
            VIEW_TYPE_SMALL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_small, parent, false)
                return NewsSmallViewHolder(view, mDelegate)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        when {
            position % 3 == 0 -> {
                return VIEW_TYPE_LARGE
            }
            else -> {
                return  VIEW_TYPE_SMALL
            }
        }
    }
}

