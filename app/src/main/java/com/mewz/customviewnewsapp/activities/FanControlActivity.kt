package com.mewz.customviewnewsapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mewz.customviewnewsapp.databinding.ActivityFanControlBinding

class FanControlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFanControlBinding

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, FanControlActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFanControlBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}