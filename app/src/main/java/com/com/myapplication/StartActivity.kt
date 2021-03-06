package com.com.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.com.myapplication.databinding.Activity1Binding

class StartActivity : AppCompatActivity() {
    var counter = 0
    var counterSource = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val counterView = binding.counterTextView

        counterView.setOnClickListener {
            when (counterSource) {
                1 -> counter++
                2 -> counter += 2
            }

            counterView.setText("$counter")
        }

        bundle?.let {
            counter = it.getInt(MainActivity.counterName, 0)
            counterSource = it.getInt(MainActivity.counterSource, 0)
            counterView.setText("$counter")
        }

        binding.okButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MainActivity.counterName, counter)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED, intent)
            finish()
        }
    }
}