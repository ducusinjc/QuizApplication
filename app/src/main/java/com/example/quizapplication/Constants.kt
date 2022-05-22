package com.example.quizapplication

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val questionOne = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionList.add(questionOne)

        val questionTwo = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )
        questionList.add(questionTwo)

        val questionThree = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )
        questionList.add(questionThree)

        val questionFour = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )
        questionList.add(questionFour)

        val questionFive = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )
        questionList.add(questionFive)

        val questionSix = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "None of these",
            1
        )
        questionList.add(questionSix)

        val questionSeven = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3
        )
        questionList.add(questionSeven)

        val questionEight = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )
        questionList.add(questionEight)

        val questionNine = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Jordan",
            "Sudan",
            "Palestine",
            1
        )
        questionList.add(questionNine)


        return questionList
    }
}