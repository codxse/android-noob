package id.nadiar.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.roll_button)
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener { rollDice() }
    }

    fun rollDice() {
        val diceText = findViewById<TextView>(R.id.dice_text)
        diceText.text = Random.nextInt(1,7).toString()
    }
}