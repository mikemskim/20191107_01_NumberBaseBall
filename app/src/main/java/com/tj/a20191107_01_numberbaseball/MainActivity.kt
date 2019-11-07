package com.tj.a20191107_01_numberbaseball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tj.a20191107_01_numberbaseball.adapters.ChatAdapter
import com.tj.a20191107_01_numberbaseball.datas.ChatData
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {

    var questionNumArray = ArrayList<Int>()
    var userInputNumArray = ArrayList<Int>()
    var chatList = ArrayList<ChatData>()
    var chatAdapter : ChatAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createQuestion()

        setupEvents()
        setValues()

    }

    fun createQuestion() {

        while(true) {
            val number = Random.nextInt(1,10) // 1~9 까지 중 랜덤한 숫자

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

    fun checkAnswer() {
        for (i in 0..2) {
            for (j in 0..2) {

            }
        }
    }

    override fun setupEvents() {

        inputBtn.setOnClickListener {
            var inputNum = inputEdt.text.toString()

            userInputNumArray.add(inputNum.toInt()/100)
            userInputNumArray.add(inputNum.toInt()/10%10)
            userInputNumArray.add(inputNum.toInt()%10)

//            var charInputArray = inputNum.toCharArray();
//            userInputNumArray.add(charInputArray.get(0).toInt())
//            userInputNumArray.add(charInputArray.get(1).toInt())
//            userInputNumArray.add(charInputArray.get(2).toInt())

            chatList.add(ChatData(inputNum, "ME"))


            chatAdapter?.notifyDataSetChanged()
            chatListView.smoothScrollToPosition(chatList.size - 1)

            checkAnswer()
        }

    }

    override fun setValues() {
        chatAdapter = ChatAdapter(this, chatList)
        chatListView.adapter = chatAdapter
    }



}
