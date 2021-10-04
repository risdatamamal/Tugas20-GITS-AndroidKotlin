package com.example.tugas18.view

import android.content.Intent
import android.os.Bundle
import android.text.Html.fromHtml
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R

class LoginActivity : AppCompatActivity() {
    lateinit var textViewRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initRegisterTextView()
    }

    private fun initRegisterTextView() {
        textViewRegister = findViewById(R.id.textViewRegister)
        textViewRegister.text = fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#ffffff'>Register</font>")

        textViewRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}