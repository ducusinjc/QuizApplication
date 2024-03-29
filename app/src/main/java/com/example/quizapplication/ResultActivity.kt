package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.tvName)
        val tvScore: TextView = findViewById(R.id.tvScore)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val finishButton: Button = findViewById(R.id.finishButton)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"

        finishButton.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}