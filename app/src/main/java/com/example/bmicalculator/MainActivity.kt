package com.example.bmicalculator

import android.annotation.SuppressLint
import android.graphics.Paint.FAKE_BOLD_TEXT_FLAG
import android.graphics.Paint.Style
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightText = findViewById<EditText>(R.id.wedit)
        val heightText = findViewById<EditText>(R.id.hedit)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            val bmiCalc = weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
            val bmiCal = String.format("%.2f",bmiCalc).toFloat()
            displayResult(bmiCal)


        }

    }
    private fun displayResult(bmi:Float){
   val result = findViewById<TextView>(R.id.rtext)
        result.text =bmi.toString()

       var resultText = ""
        var color = 0
        val info = findViewById<TextView>(R.id.info)
        if(bmi<18.5){
            resultText = "You Are Under Weight !!!"
            color = R.color.underweight
        }
        else if (bmi>=18.5 && bmi <= 24.9){
            resultText = "You are Normal !!!"
            color = R.color.normal
        }else if(bmi>=24.9){
            resultText = "You Are Over Weight !!!"
            color = R.color.overweight
        }
        info.setTextColor(ContextCompat.getColor(this,color))
        info.text=resultText
    }

}