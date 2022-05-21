package com.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.com.myapplication.databinding.Activity4Binding
import com.com.myapplication.databinding.ActivityMain3Binding

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}