package com.example.tugas18.view

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R

class RegisterActivity : AppCompatActivity() {
    lateinit var textViewLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        inittvViewLogin()
    }

    private fun inittvViewLogin() {
        textViewLogin = findViewById(R.id.textViewLogin)
        textViewLogin.text =
            Html.fromHtml("<font color='#000000'>I have account, </font><font color='#0c0099'>Login</font>")

        textViewLogin.setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}