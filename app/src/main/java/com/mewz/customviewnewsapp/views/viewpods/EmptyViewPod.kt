package com.mewz.customviewnewsapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.mewz.customviewnewsapp.activities.MainActivity
import com.mewz.customviewnewsapp.databinding.ViewPodEmptyBinding

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private lateinit var binding: ViewPodEmptyBinding
    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ViewPodEmptyBinding.bind(this)
        setUpListener()
    }

    fun setEmptyData(emptyMessage: String, emptyImageUrl: String){
        binding.tvEmpty.text = emptyMessage

        Glide.with(context)
            .load(emptyImageUrl)
            .into(binding.ivEmptyImage)
    }

    fun setDelegate(delegate: Delegate){
        mDelegate = delegate
    }

    private fun setUpListener() {
        binding.btnTryAgain.setOnClickListener {
            mDelegate?.onTapTryAgain()
        }
    }

    interface Delegate {
        fun onTapTryAgain()
    }
}