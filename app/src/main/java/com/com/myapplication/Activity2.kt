package com.com.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.com.myapplication.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity2)

        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val colorList = arrayListOf(
            R.color.view1a,
            R.color.view1b,
            R.color.view1c,
            R.color.view2a,
            R.color.view2b,
            R.color.view2c,
            R.color.view3a,
            R.color.view3b,
            R.color.view3c
        ).map { ContextCompat.getColor(this, it) }

        val viewList = arrayListOf(
            binding.view1a, binding.view1b, binding.view1c,
            binding.view2a, binding.view2b, binding.view2c,
            binding.view3a, binding.view3b, binding.view3c
        )


        viewList[0].setOnClickListener {
            val color = colorList[8]
            viewList[0].setBackgroundColor(color)
        }
    }
}