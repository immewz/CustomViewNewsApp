package com.mewz.customviewnewsapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.mewz.customviewnewsapp.data.vos.NewsVO
import com.mewz.customviewnewsapp.databinding.ViewPodReactionBinding

class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private lateinit var binding: ViewPodReactionBinding
    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ViewPodReactionBinding.bind(this)
        setUpListener()
    }

    fun setDelegate(delegate: Delegate){
        mDelegate = delegate
    }

    fun bindData(data: NewsVO){
        binding.tvLikedUser.text = data.likedUsers.count().toString()
        binding.tvCommentedUser.text = data.likedUsers.count().toString()
    }

    private fun setUpListener() {
        binding.tvLike.setOnClickListener {
            mDelegate?.onTapLike()
        }
        binding.tvComment.setOnClickListener {
            mDelegate?.onTapComment()
        }
        binding.tvShare.setOnClickListener {
            mDelegate?.onTapShare()
        }
    }

    interface  Delegate{
        fun onTapLike()
        fun onTapComment()
        fun onTapShare()
    }

}

