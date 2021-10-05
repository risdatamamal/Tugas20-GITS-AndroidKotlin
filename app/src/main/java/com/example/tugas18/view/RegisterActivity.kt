package com.example.tugas18.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R
import com.example.tugas18.utils.Preferences

class RegisterActivity : AppCompatActivity() {
    lateinit var buttonBackHome: ImageView
    lateinit var buttonContinue: Button

    lateinit var sFullName: String
    lateinit var sPassword: String
    lateinit var sEmail: String
    lateinit var sProfession: String

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initButtonBack()
        initButtonContinue()

        preferences = Preferences(this)
    }

    private fun initButtonContinue() {
        buttonContinue = findViewById(R.id.btnRegister)
        buttonContinue.setOnClickListener {
//            sFullName = et_fullname.text.toString()
//            sPassword = et_password.text.toString()
//            sEmail = et_email.text.toString()
//            sProfession = et_profession.text.toString()
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