package com.mewz.customviewnewsapp.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mewz.customviewnewsapp.R
import com.mewz.customviewnewsapp.data.vos.NewsVO
import com.mewz.customviewnewsapp.databinding.ItemNewsSmallBinding
import com.mewz.customviewnewsapp.delegates.NewsItemDelegate
import com.mewz.customviewnewsapp.views.viewpods.ReactionViewPod

class NewsSmallViewHolder(itemView: View,private val delegate: NewsItemDelegate)
    : BaseNewsViewHolder(itemView) {

    private var binding: ItemNewsSmallBinding
    private val mViewPodReaction: ReactionViewPod = itemView.findViewById(R.id.viewPodReaction) as ReactionViewPod

    init {
        binding = ItemNewsSmallBinding.bind(itemView)
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapNewsItem(it.id)
            }
        }
    }

    override fun bindData(data: NewsVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(binding.ivNewsImage)
        binding.tvNewsHeadLine.text = data.title

        mViewPodReaction.bindData(data)
        mViewPodReaction.setDelegate(delegate)
    }
}