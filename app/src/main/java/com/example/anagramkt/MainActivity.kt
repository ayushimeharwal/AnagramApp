package com.example.anagramkt

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val dictionary = arrayOf(
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten"
    )
    var r= Random()

    var currentWord=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv_info = findViewById<TextView>(R.id.tv_info)
        var tv_word = findViewById<TextView>(R.id.tv_word)
        var b_check = findViewById<Button>(R.id.b_check)
        var b_new = findViewById<Button>(R.id.b_new)
        var et_guess = findViewById<EditText>(R.id.et_guess)



        b_check.setOnClickListener(View.OnClickListener {
            if (et_guess.getText().toString().equals(currentWord, ignoreCase = true)) {
                tv_info.setText("!AWESOME")
                b_check.setEnabled(false)
                b_new.setEnabled(true)
            }
          else
                Toast.makeText(this@MainActivity, "GAME OVER", Toast.LENGTH_SHORT).show();

        })
        b_new.setOnClickListener(View.OnClickListener { newgame() })

    }

    private fun shuffleWord(word: String): String? {
        val letters = Arrays.asList(*word.split("").toTypedArray())
        Collections.shuffle(letters)
        var shuffled: String? = ""
        for (letter in letters) shuffled += letter
        return shuffled
    }

    private fun newgame() {

        currentWord = dictionary.get(r.nextInt(dictionary.size))
        tv_word.setText(shuffleWord(currentWord))
        et_guess.setText("")
        tv_info.setText("");
        b_new.setEnabled(false)
        b_check.setEnabled(true)

    }
}





