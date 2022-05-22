package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.quizapplication.Constants.CORRECT_ANSWERS
import com.example.quizapplication.Constants.TOTAL_QUESTIONS
import com.example.quizapplication.Constants.USER_NAME

class QuizQuestionActivity : AppCompatActivity(), OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    private var tvProgressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null
    private var mUserName: String? = null

    private var tvChoiceOne: TextView? = null
    private var tvChoiceTwo: TextView? = null
    private var tvChoiceThree: TextView? = null
    private var tvChoiceFour: TextView? = null

    private var submitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        tvProgress = findViewById(R.id.tvProgress)
        tvProgressBar = findViewById(R.id.tvProgressBar)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvImage = findViewById(R.id.tvImage)
        mUserName = intent.getStringExtra(USER_NAME)

        tvChoiceOne = findViewById(R.id.tvChoiceOne)
        tvChoiceTwo = findViewById(R.id.tvChoiceTwo)
        tvChoiceThree = findViewById(R.id.tvChoiceThree)
        tvChoiceFour = findViewById(R.id.tvChoiceFour)
        submitButton = findViewById(R.id.submitButton)

        tvChoiceOne?.setOnClickListener(this)
        tvChoiceTwo?.setOnClickListener(this)
        tvChoiceThree?.setOnClickListener(this)
        tvChoiceFour?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)



        mQuestionList = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion(){
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition-1]
        tvProgressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${tvProgressBar?.max}"
        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)

        tvChoiceOne?.text = question.choiceOne
        tvChoiceTwo?.text = question.choiceTwo
        tvChoiceThree?.text = question.choiceThree
        tvChoiceFour?.text = question.choiceFour

        if(mCurrentPosition == mQuestionList!!.size){
            submitButton?.text = getString(R.string.buttonFinishText)
        }else{
            submitButton?.text = getString(R.string.buttonSubmitText)
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()

        tvChoiceOne?.let{
            options.add(0, it)
        }
        tvChoiceTwo?.let{
            options.add(1, it)
        }
        tvChoiceThree?.let{
            options.add(2, it)
        }
        tvChoiceFour?.let{
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#FF7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#FF363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_background)
    }


    override fun onClick(view: View) {
        when(view?.id){
            R.id.tvChoiceOne -> {tvChoiceOne?.let{selectedOptionView(it,1)}}
            R.id.tvChoiceTwo -> {tvChoiceTwo?.let{selectedOptionView(it,2)}}
            R.id.tvChoiceThree -> {tvChoiceThree?.let{selectedOptionView(it,3)}}
            R.id.tvChoiceFour -> {tvChoiceFour?.let{selectedOptionView(it,4)}}
            R.id.submitButton -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {setQuestion()}
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(USER_NAME, mUserName)
                            intent.putExtra(CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.corrected_option_border_bg)
                }
                if(mCurrentPosition == mQuestionList!!.size){
                    submitButton?.text = getString(R.string.buttonFinishText)
                }else{
                    submitButton?.text = getString(R.string.buttonNextText)
                }
                mSelectedOptionPosition = 0
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when (answer){
            1 -> {tvChoiceOne?.background = ContextCompat.getDrawable(this,drawableView)}
            2 -> {tvChoiceTwo?.background = ContextCompat.getDrawable(this,drawableView)}
            3 -> {tvChoiceThree?.background = ContextCompat.getDrawable(this,drawableView)}
            4 -> {tvChoiceFour?.background = ContextCompat.getDrawable(this,drawableView)}
        }

    }

}