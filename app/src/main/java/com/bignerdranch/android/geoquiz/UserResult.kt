package com.bignerdranch.android.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.NumberFormat

class UserResult : AppCompatActivity() {
    lateinit var fullName: TextView
    lateinit var score: TextView
    lateinit var resultStatement: TextView
    lateinit var repeat: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_result)

        fullName = findViewById(R.id.full_name)
        score = findViewById(R.id.total_score)
        resultStatement = findViewById(R.id.result_statement)
        repeat = findViewById(R.id.return_button)

        repeat.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val examinees = intent.getSerializableExtra("EXAMINEES") as Examinees
        fullName.text = "${examinees.firstName} ${examinees.lastName}"
        score.text = " نمبری: ${examinees.score.toString()}/105"
        resultStatement.text = " صحیح ځوابونه: ${examinees.numCorrect}/21"
    }
}