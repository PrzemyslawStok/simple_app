package com.com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.com.myapplication.databinding.Activity1Binding

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        bundle?.let {
            val counter = it.getInt("Counter", 0)
            binding.counterTextView.setText("$counter")
        }
    }
}