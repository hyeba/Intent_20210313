package com.neppplus.intent_20210313

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_first.*

class MyFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_first)
        moveToBackBtn.setOnClickListener {

            val myBack = Intent(this, MainActivity::class.java)

            startActivity(myBack)

        }



    }
}