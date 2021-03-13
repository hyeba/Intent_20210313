package com.neppplus.intent_20210313

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToFirstBtn.setOnClickListener {

//            출발지/목적지 정보: 비행기 티켓 발권

            val myIntent = Intent(this, MyFirstActivity::class.java)

//            티켓 들고 비행기 탑승하는 행위
            startActivity(myIntent)

        }

        moveToSecondBtn.setOnClickListener {

//            어떤 내용이 적혔는지?

            val inputMessage = messageEdt.text.toString()

            //화면 이동인건 동일 => INTENT 기초 사용법은 그대로 적용

//            비행기티켓

            val myIntent = Intent(this, MySecondActivity::class.java)

//            티켓에 데이터 추가기록

            myIntent.putExtra("message", inputMessage)

            // 실제 탑승

            startActivity(myIntent)
        }

        editNickBtn.setOnClickListener {

            val myIntent = Intent(this, EditNicknameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)

        }

        dialBtn.setOnClickListener {

//            입력한 폰번이 뭔지?
            val inputPhoneNum = phoneNumEdt.text.toString()

//            Uri - 어디로 전화를 걸건지 등 세부 정보 표현
            val myUri = Uri.parse("tel:${inputPhoneNum}")

//            Intent 생성 = 출발지/도착지 대신, 안드로이드의 어떤 기능(action)? + 세부 정보(uri)?
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

//            실제 화면 이동
            startActivity(myIntent)

        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        이 함수가 실행된 이유 => 닉네임을 가지러 다녀온게 맞는지? => requestCode를 확인

        if(requestCode == REQ_FOR_NICKNAME) {

//            추가 질문 => OK를 누른게 맞는지? => resultCode를 확인
            if (resultCode == Activity.RESULT_OK) {

//                첨부해준 데이터 => (data 변수) 를 받아서 텍스트뷰에 반영

                val newNickname = data?.getStringExtra("nick")

                nicknameTxt.text = newNickname

            }

        }

    }

}