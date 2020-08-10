package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImageLeft: ImageView
    lateinit var diceImageRight: ImageView
    lateinit var rollButton: Button
    lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImageLeft = findViewById(R.id.dice_image_left)
        diceImageRight = findViewById(R.id.dice_image_right)
        rollButton = findViewById(R.id.roll_button)
        clearButton = findViewById(R.id.clear_text)

        rollButton.setOnClickListener { rollDice() }
        clearButton.setOnClickListener { rollDice(0) }
    }

    private fun getRandomInt() = (1..6).random()

    private fun getDiceImage(diceValue: Int) = when (diceValue) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.empty_dice
    }

    private fun rollDice(nextValue: Int? = null) {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        diceImageLeft.setImageResource(getDiceImage(nextValue ?: getRandomInt()))
        diceImageRight.setImageResource(getDiceImage(nextValue ?: getRandomInt()))
    }
}