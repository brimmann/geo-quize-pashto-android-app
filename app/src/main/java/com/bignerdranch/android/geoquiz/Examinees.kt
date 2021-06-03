package com.bignerdranch.android.geoquiz

import java.io.Serializable

data class Examinees(var firstName: String = "", var lastName: String = "", var numCorrect: Int = 0, var numIncorrect: Int = 0) : Serializable{
    var score: Int = 0
    fun calculateScore(){
        score = 5 * numCorrect
    }
}