package com.com.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview1: TextView = findViewById(R.id.textView1)
        textview1.setText("Nowy tekst")

        val startButton: Button = findViewById(R.id.button_start)
        startButton.setOnClickListener {
            textview1.setText("Kolejny tekst: $counter")
        }

    }
}