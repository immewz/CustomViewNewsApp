package com.mewz.customviewnewsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showDialog()
    }

    fun showSnackBar(message: String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_LONG).show()
    }

    private fun showDialog() {

    }
}