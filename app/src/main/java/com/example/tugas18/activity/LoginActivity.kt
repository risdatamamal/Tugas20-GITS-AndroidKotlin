package com.example.tugas18.activity

import android.content.Intent
import android.os.Bundle
import android.text.Html.fromHtml
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R
import com.example.tugas18.presenter.LoginPresenter
import com.example.tugas18.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initRegisterTextView()

        /*// Call a Presenter
        val loginPresenter = LoginPresenter(this)*/
    }

    private fun initRegisterTextView() {
        textViewRegister.text = fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#ffffff'>Register</font>")
        textViewRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}