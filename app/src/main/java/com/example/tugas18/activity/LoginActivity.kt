package com.example.tugas18.activity

import android.content.Intent
import android.os.Bundle
import android.text.Html.fromHtml
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R
import com.example.tugas18.presenter.LoginPresenter
import com.example.tugas18.presenter.RegisterPresenter
import com.example.tugas18.utils.Preferences
import com.example.tugas18.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var preferences: Preferences

    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Pesan"
            message = msg ?: ""
        }.show()
    }

    override fun onErrorRegister(msg: String?) {
        alert {
            title = "Gagal"
            message = msg ?: ""
        }.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Button Register
        buttonRegister()

        // Call a Function Presenter
        callPresenter()

        // Shared Preferences
        preferences = Preferences(this)
    }

    private fun callPresenter() {
        val loginPresenter = LoginPresenter(this)
        btnLogin.setOnClickListener {
            val sEmail = login_email.text.toString()
            val sPassword = login_password.text.toString()

            if (sEmail == "") {
                login_email.error = "Silahkan isi Email"
                login_email.requestFocus()
            } else if (sPassword == "" && sPassword.length == 8) {
                login_password.error = "Silahkan isi Password"
                login_password.requestFocus()
            } else {
                loginPresenter.login(sEmail, sPassword)
            }
        }
    }

    private fun buttonRegister() {
        textViewRegister.text = fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#ffffff'>Register</font>")
        textViewRegister.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}