package com.example.tugas18.view

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R

class RegisterActivity : AppCompatActivity() {
    lateinit var buttonBackHome: ImageView
    lateinit var buttonContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initButtonBack()
        initButtonContinue()
    }

    private fun initButtonContinue() {
        buttonContinue = findViewById(R.id.btnRegister)
        buttonContinue.setOnClickListener{
            intent = Intent(this, RegisterUploadPhotoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initButtonBack() {
        buttonBackHome = findViewById(R.id.btn_back)
        buttonBackHome.setOnClickListener {
            onBackPressed()
        }
    }

}