package com.com.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var counter = 0
    var counterTextView: TextView? = null

    companion object {
        val counterName = "counter"

        val requestCodeStart = 10
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout: LinearLayout = findViewById(R.id.main_layout)

        counterTextView = findViewById(R.id.textView1)
        counterTextView?.setText("$counter")

        mainLayout.setOnClickListener {
            counter++
            counterTextView?.setText("$counter")
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
        val startButtonR: Button = findViewById(R.id.button_start_register)


        startButton.setOnClickListener {

            val intent = Intent(this, StartActivity::class.java)
            intent.putExtra(counterName, counter)
            //startActivity(intent)

            startActivityForResult(intent, requestCodeStart)

            Toast.makeText(this, "Naciśnięto start", Toast.LENGTH_SHORT).show()
        }

        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            }

        startButtonR.setOnClickListener{
            val intent = Intent(this, StartActivity::class.java)
            intent.putExtra(counterName, counter)

            getResult.launch(intent)
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

                    val bundle = it.extras

                    bundle?.let {
                        counter = it.getInt(MainActivity.counterName, 0)
                        counterTextView?.setText("$counter")
                    }
                }
            }
            RESULT_CANCELED -> {
                Toast.makeText(this, "Anulowano", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}