package com.bignerdranch.android.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UserInput : AppCompatActivity() {

    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var resultButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_input)
        firstName = findViewById(R.id.first_name)
        lastName = findViewById(R.id.last_name)
        resultButton = findViewById(R.id.result_button)

        resultButton.setOnClickListener {
            var examinees = intent.getSerializableExtra("EXAMINEES") as Examinees
            if(firstName.text.toString().equals("") || lastName.text.toString().equals("")){
                Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show()
            }else{
                examinees.firstName = firstName.text.toString()
                examinees.lastName = lastName.text.toString()
                val intent: Intent = Intent(this, UserResult::class.java)
                intent.putExtra("EXAMINEES", examinees)
                startActivity(intent)
            }
        }

    }
}