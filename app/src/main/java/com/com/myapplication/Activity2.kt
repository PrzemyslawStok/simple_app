package com.com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.com.myapplication.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity2)

        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val view1a = binding.view1a
        val view1b = binding.view1b


    }
}