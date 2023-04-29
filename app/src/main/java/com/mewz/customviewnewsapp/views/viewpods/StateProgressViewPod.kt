package com.mewz.customviewnewsapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.mewz.customviewnewsapp.R
import com.mewz.customviewnewsapp.databinding.ViewPodStateProgressBinding

class StateProgressViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private lateinit var binding: ViewPodStateProgressBinding
    private var isCompleteAllSteps = false
    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ViewPodStateProgressBinding.bind(this)
        setUpListeners()
    }

    fun setDelegate(delegate: Delegate){
        mDelegate = delegate
    }

    fun completeAllSteps(){
        isCompleteAllSteps = true
    }

    fun setStepDescription(
        step1Desc: String,
        step2Desc: String,
        step3Desc: String,
        step4Desc: String
    ){
        binding.tvDesc1.text = step1Desc
        binding.tvDesc2.text = step2Desc
        binding.tvDesc3.text = step3Desc
        binding.tvDesc4.text = step4Desc

    }

    fun onTapStep1() {
        setCircle1Selected()
        setCircle2UnSelected()
        setCircle3UnSelected()
        setCircle4UnSelected()
    }

    fun onTapStep2() {
        setCircle1Selected()
        setCircle2Selected()
        setCircle3UnSelected()
        setCircle4UnSelected()
    }

    fun onTapStep3() {
        setCircle1Selected()
        setCircle2Selected()
        setCircle3Selected()
        setCircle4UnSelected()
    }

    fun onTapStep4() {
        setCircle1Selected()
        setCircle2Selected()
        setCircle3Selected()
        setCircle4Selected()
    }

    private fun setUpListeners() {
        binding.tvCircle1.setOnClickListener {
            if (isCompleteAllSteps){
                onTapStep1()
                mDelegate?.onTapStep1()
            }
        }

        binding.tvCircle2.setOnClickListener {
            if (isCompleteAllSteps){
                onTapStep2()
                mDelegate?.onTapStep2()
            }
        }

        binding.tvCircle3.setOnClickListener {
            if (isCompleteAllSteps){
                onTapStep3()
                mDelegate?.onTapStep3()
            }
        }

        binding.tvCircle4.setOnClickListener {
            if (isCompleteAllSteps){
                onTapStep4()
                mDelegate?.onTapStep4()
            }
        }
    }

    private fun setCircle1Selected(){
        binding.tvCircle1.background = context.getDrawable(R.drawable.shape_circle_accent)
        binding.tvCircle1.text = "1"
    }

    private fun setCircle2Selected() {
        binding.tvCircle2.background = context.getDrawable(R.drawable.shape_circle_accent)
        binding.view2.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        binding.tvCircle2.text = "2"
    }

    private fun setCircle3Selected() {
        binding.tvCircle3.background = context.getDrawable(R.drawable.shape_circle_accent)
        binding.view3.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        binding.tvCircle3.text = "3"
    }

    private fun setCircle4Selected() {
        binding.tvCircle4.background = context.getDrawable(R.drawable.shape_circle_accent)
        binding.view4.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        binding.tvCircle4.text = "4"
    }

    private fun setCircle2UnSelected() {
        binding.tvCircle2.background = context.getDrawable(R.drawable.shape_circle)
        binding.view2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        binding.tvCircle2.text = ""
    }

    private fun setCircle3UnSelected() {
        binding.tvCircle3.background = context.getDrawable(R.drawable.shape_circle)
        binding.view3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        binding.tvCircle3.text = ""
    }

    private fun setCircle4UnSelected() {
        binding.tvCircle4.background = context.getDrawable(R.drawable.shape_circle)
        binding.view4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        binding.tvCircle4.text = ""
    }

    interface Delegate{
        fun onTapStep1()
        fun onTapStep2()
        fun onTapStep3()
        fun onTapStep4()
    }

}