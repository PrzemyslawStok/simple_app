package com.com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.com.myapplication.databinding.Activity1Binding

class StartActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val counterView = binding.counterTextView

        counterView.setOnClickListener {
            counter++
            counterView.setText("$counter")
        }

        bundle?.let {
            counter = it.getInt("Counter", 0)
            counterView.setText("$counter")
        }
    }
}