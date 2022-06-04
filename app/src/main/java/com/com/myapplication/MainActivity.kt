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

    companion object {
        val counterName = "counter"

        val requestCodeStart = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout: LinearLayout = findViewById(R.id.main_layout)

        val textview1: TextView = findViewById(R.id.textView1)
        textview1.setText("$counter")

        mainLayout.setOnClickListener {
            counter++
            textview1.setText("$counter")
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

        val startButton: Button = findViewById(R.id.button_start)
        startButton.setOnClickListener {

            val intent = Intent(this, StartActivity::class.java)
            intent.putExtra(counterName, counter)
            //startActivity(intent)
            startActivityForResult(intent, requestCodeStart)

            Toast.makeText(this, "Naciśnięto start", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //Toast.makeText(this, "requestCode $requestCode, resultCode $resultCode", Toast.LENGTH_LONG)
        //    .show()

        when (requestCode) {
            requestCodeStart -> {
                resultStartActivity(resultCode, data)
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    fun resultStartActivity(resultCode: Int, data: Intent?) {
        when (resultCode) {
            RESULT_OK -> {
                data?.let {
                    Toast.makeText(this, "resultCode $resultCode", Toast.LENGTH_LONG)
                        .show()

                    val bundle = intent.extras

                    bundle?.let {
                        counter = it.getInt(MainActivity.counterName, 0)
                    }
                }
            }
            RESULT_CANCELED -> {

            }
        }
    }
}