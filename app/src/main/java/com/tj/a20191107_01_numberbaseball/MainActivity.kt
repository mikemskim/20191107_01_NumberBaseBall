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

    override fun setupEvents() {

    }

    override fun setValues() {
        chatAdapter = ChatAdapter(this, chatList)
        chatListView.adapter = chatAdapter
    }

}
