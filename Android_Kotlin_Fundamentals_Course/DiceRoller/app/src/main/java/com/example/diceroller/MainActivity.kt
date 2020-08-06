package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val DEFAULT_RESULT_VALUE = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText: TextView = findViewById(R.id.result_text)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countButton: Button = findViewById(R.id.count_up)
        val clearButton: Button = findViewById(R.id.clear_text)

        rollButton.setOnClickListener { resultText.text = rollDice().toString() }
        countButton.setOnClickListener { resultText.text = countUp(resultText).toString() }
        clearButton.setOnClickListener { resultText.text = this.DEFAULT_RESULT_VALUE }
    }

    private fun rollDice(): Int {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        return (1..6).random()
    }

    private fun countUp(text_view: TextView, maxValue: Int = 6, step: Int = 1): Int {
        val tempInt = text_view.text.toString().toIntOrNull() ?: 0
        return if (tempInt < maxValue) tempInt + step else tempInt
    }
}