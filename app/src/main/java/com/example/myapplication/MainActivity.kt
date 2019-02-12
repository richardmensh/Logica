package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var leftArray =  ArrayList<TextView>()
    private var rightArray =  ArrayList<TextView>()
    private var answers = ArrayList<EditText>()
    private var logica = listOf("T", "F")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addTextViews()
        addAnswers()

        for (i in 0..(leftArray.size - 1)) {
            var random = (0..(logica.size - 1)).random()
            var random2 = (0..(logica.size - 1)).random()
            leftArray[i].setText(logica[random])
            rightArray[i].setText(logica[random2])

        }

        checkAnswers.setOnClickListener {
            var count = 0;
            for (i in 0..(answers.size - 1)) {
                val leftText = leftArray[i].text.toString()
                val rightText = rightArray[i].text.toString()
                val answerValue = answers[i].text.toString()

                if (checkAnswer(leftText, rightText, answerValue)) {
                    count++
                }

            }
            Toast.makeText(this@MainActivity, "You got " + count + "correct", Toast.LENGTH_SHORT).show()
        }

    }


    fun addTextViews() {
        leftArray.add(leftQuestion1)
        leftArray.add(leftQuestion2)
        leftArray.add(leftQuestion3)
        leftArray.add(leftQuestion4)

        rightArray.add(rightQuestion1)
        rightArray.add(rightQuestion2)
        rightArray.add(rightQuestion3)
        rightArray.add(rightQuestion4)

    }

    fun addAnswers() {
        answers.add(answer1)
        answers.add(answer2)
        answers.add(answer3)
        answers.add(answer4)

    }
    fun checkAnswer(check1: String, check2: String, answer: String) : Boolean {

        if (check1 == "T" && check2 == "T" && answer == "T") {
            return true
        } else if(check1 == "F" && check2 == "F" && answer == "F") {
            return true
        } else if(check1 == "T" && check2 == "F" && answer == "F") {
            return true
        }
        else if(check1 == "F" && check2 == "T" && answer == "F") {
            return true
        }

        return false

    }
}
