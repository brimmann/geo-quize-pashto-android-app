package com.bignerdranch.android.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var questionTextView: TextView
    var examinees: Examinees = Examinees()

    private val questionBank = listOf(
        Question(R.string.q_1, false),
        Question(R.string.q_2, true),
        Question(R.string.q_3, false),
        Question(R.string.q_4, true),
        Question(R.string.q_5, false),
        Question(R.string.q_6, true),
        Question(R.string.q_7, false),
        Question(R.string.q_8, true),
        Question(R.string.q_9, false),
        Question(R.string.q_10, true),
        Question(R.string.q_11, false),
        Question(R.string.q_12, false),
        Question(R.string.q_13, true),
        Question(R.string.q_14, true),
        Question(R.string.q_15, false),
        Question(R.string.q_16, true),
        Question(R.string.q_17, false),
        Question(R.string.q_18, true),
        Question(R.string.q_19, false),
        Question(R.string.q_20, false),
        Question(R.string.q_21, true))

    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            passAnswer(true)
            currentIndex += 1
            updateQuestion()

        }

        falseButton.setOnClickListener { view: View? ->
            passAnswer(false)
            currentIndex += 1
            updateQuestion()
        }
        updateQuestion()
    }

    private fun updateQuestion(){
        if(currentIndex < 21){
            val questionTextResId = questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
        } else{
            val intent: Intent = Intent(this, UserInput::class.java)
            examinees.calculateScore()
            intent.putExtra("EXAMINEES", examinees)
            startActivity(intent)
        }
    }

    private fun passAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        if(userAnswer == correctAnswer) examinees.numCorrect += 1
        else examinees.numIncorrect += 1
    }
}