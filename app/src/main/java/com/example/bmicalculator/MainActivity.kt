package com.example.bmicalculator


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buttonClicked(v: View) {
        val editTextHeight = findViewById<EditText>(R.id.userHeight)
        val editTextWeight = findViewById<EditText>(R.id.userWeight)
        val textViewResult = findViewById<TextView>(R.id.userBMI)

        var height = java.lang.Double.parseDouble(editTextHeight.text.toString())/100
        var weight = java.lang.Double.parseDouble(editTextWeight.text.toString())
        var bmi = weight / (height * height)

        when {
            bmi < 18.5 -> textViewResult.text = String.format("%.2f", bmi) + "\n" + getString(R.string.string_underweight)
            bmi < 25 -> textViewResult.text = String.format("%.2f", bmi) + "\n" + getString(R.string.string_healthy)
            bmi < 30 -> textViewResult.text = String.format("%.2f", bmi) + "\n" + getString(R.string.string_overweight)
            else -> textViewResult.text = String.format("%.2f", bmi) + "\n" + getString(R.string.string_obese)
        }
    }
}
