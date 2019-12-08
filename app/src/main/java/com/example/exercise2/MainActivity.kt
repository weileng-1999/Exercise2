package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculationButton: Button = findViewById(R.id.buttonCalculate)
        calculationButton.setOnClickListener { calculate() }

        val resetButton: Button = findViewById(R.id.buttonReset)
        resetButton.setOnClickListener { reset() }
    }

    private fun reset() {
        val image: ImageView = findViewById(R.id.imageViewProfile)

        editTextHeight.setText("")
        editTextWeight.setText("")
        image.setImageResource(R.drawable.empty )
        TotalBMI.setText("")
    }

    private fun calculate() {
        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()
        val bmi = weight / (height * height)

        val image: ImageView = findViewById(R.id.imageViewProfile)

        if (bmi < 18.5) {
            R.drawable.under
            image.setImageResource(R.drawable.under)
        } else if (bmi > 18.5 && bmi < 24.9) {
            R.drawable.normal
            image.setImageResource(R.drawable.normal)
        } else {
            R.drawable.over
            image.setImageResource(R.drawable.over)
        }
        TotalBMI.setText(String.format("%.2f", bmi))

    }
}
