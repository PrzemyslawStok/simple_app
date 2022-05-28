package com.com.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout: LinearLayout = findViewById(R.id.main_layout)

        val textview1: TextView = findViewById(R.id.textView1)
        textview1.setText("$counter")

        val startButton: Button = findViewById(R.id.button_start)
        startButton.setOnClickListener {

            val intent = Intent(this, StartActivity::class.java)
            intent.putExtra("Counter1", counter)
            startActivity(intent)

            Toast.makeText(this, "Naciśnięto start", Toast.LENGTH_SHORT).show()
        }

        mainLayout.setOnClickListener {
            textview1.setText("$counter")
            counter++
        }

        val activity2Button: Button = findViewById(R.id.button_activity2)
        activity2Button.setOnClickListener {

            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

        val constraintActivityButton: Button = findViewById(R.id.button_activity_3)

        constraintActivityButton.setOnClickListener {

            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }

        val constraint2Button: Button = findViewById(R.id.constraint_activity_2)

        constraint2Button.setOnClickListener {

            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }


    }
}