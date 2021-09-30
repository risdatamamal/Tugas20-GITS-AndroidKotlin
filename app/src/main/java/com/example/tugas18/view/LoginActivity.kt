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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initRegisterTextView()
    }

    private fun initRegisterTextView() {
        textViewRegister = findViewById(R.id.textViewRegister)
        textViewRegister.text = fromHtml("<font color='#000000'>I don't have account yet. </font><font color='#0c0099'>Create One</font>")

        textViewRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}