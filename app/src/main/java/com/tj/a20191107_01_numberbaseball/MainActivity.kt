package com.tj.a20191107_01_numberbaseball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.random.Random

class MainActivity : BaseActivity() {

    var questionNumArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createQuestion()

        setupEvents()
        setValues()

    }

    fun createQuestion() {


        while(true) {
            val number = Random.nextInt(1,9)

            if (!questionNumArray.contains(number)) {
                questionNumArray.add(number)
            }
            if (questionNumArray.size == 3) {
                break
            }
        }

        for (num in questionNumArray) {
            Log.d("출제숫자",num.toString())
        }

    }

    override fun setupEvents() {
    }

    override fun setValues() {
    }




}
