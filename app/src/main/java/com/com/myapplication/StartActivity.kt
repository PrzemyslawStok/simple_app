package com.com.myapplication

import android.content.Intent
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
            counter = it.getInt(MainActivity.counterName, 0)
            counterView.setText("$counter")
        }

        binding.returnButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MainActivity.counterName, counter)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}