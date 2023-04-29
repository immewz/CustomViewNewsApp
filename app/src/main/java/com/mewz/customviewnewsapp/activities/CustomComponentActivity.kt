package com.mewz.customviewnewsapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mewz.customviewnewsapp.databinding.ActivityCustomComponentBinding
import com.mewz.customviewnewsapp.views.components.EmotionalFaceView

class CustomComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomComponentBinding

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, CustomComponentActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1
        binding.happyButton.setOnClickListener {
            binding.emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
        }

        // 2
        binding.sadButton.setOnClickListener {
            binding.emotionalFaceView.happinessState = EmotionalFaceView.SAD
        }

        binding.btnNavigate.setOnClickListener {
            startActivity(FanControlActivity.newIntent(this))
        }
    }
}