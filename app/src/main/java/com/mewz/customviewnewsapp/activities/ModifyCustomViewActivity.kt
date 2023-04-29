package com.mewz.customviewnewsapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mewz.customviewnewsapp.databinding.ActivityModifyCustomViewBinding
import com.mewz.customviewnewsapp.views.viewpods.StateProgressViewPod

class ModifyCustomViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModifyCustomViewBinding
    private lateinit var mViewPodStateProgress: StateProgressViewPod

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context,ModifyCustomViewActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPod()
        setUpListener()
    }

    private fun setUpListener() {
        binding.btn1.setOnClickListener {
            mViewPodStateProgress.onTapStep1()
        }

        binding.btn2.setOnClickListener {
            mViewPodStateProgress.onTapStep2()
        }

        binding.btn3.setOnClickListener {
            mViewPodStateProgress.onTapStep3()
        }

        binding.btn4.setOnClickListener {
            mViewPodStateProgress.onTapStep4()
        }

        binding.btnNavigate.setOnClickListener {
            startActivity(CustomComponentActivity.newIntent(this))
        }
    }

    private fun setUpViewPod() {
        mViewPodStateProgress = binding.viewPodStateProgress.root
        mViewPodStateProgress.apply {
            setStepDescription("Survey", "Cabling", "Splicing", "Activate")
        }
    }
}