package com.neppplus.intent_20210313

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_second.*

class MySecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_second)

//        메인에서 첨부한 데이터를 => 화면에 들어오자마자 바로 찾아주자 => 변수에 담아두자

        val message = intent.getStringExtra("message")

//        텍스트뷰에 반영

        messageTxt.text = message



    }
}