package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var diceImageView: ImageView
    private lateinit var topText: TextView
    private lateinit var restartButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topText = findViewById(R.id.top_text)
        rollButton = findViewById(R.id.roll_button)
        diceImageView = findViewById(R.id.dice_image)
        restartButton = findViewById(R.id.restart_button)


        rollDice()
        restart()
    }

    private fun restart() {
        restartButton.setOnClickListener {
            topText.text = ""
            diceImageView.setImageResource(R.drawable.empty_dice)
            rollButton.text = "Roll the dice"
            Toast.makeText(this, "Your dice has been reset", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        rollButton.text = "Roll the dice"
        rollButton.setOnClickListener {
            rollButton.text = "Roll Again!"

            val randomInt = Random().nextInt(6) + 1
            val drawableResource = when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            when (randomInt) {
                1 -> topText.text = "You rolled 1 !"
                2 -> topText.text = "You rolled 2 !"
                3 -> topText.text = "You rolled 3 !"
                4 -> topText.text = "You rolled 4 !"
                5 -> topText.text = "You rolled 5 !"
                else -> topText.text = "You rolled 6 !"
            }
            diceImageView.setImageResource(drawableResource)
        }
    }
}