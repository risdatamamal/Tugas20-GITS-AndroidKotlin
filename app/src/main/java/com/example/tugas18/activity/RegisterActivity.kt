package com.example.tugas18.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R
import com.example.tugas18.presenter.RegisterPresenter
import com.example.tugas18.utils.Preferences
import com.example.tugas18.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert

class RegisterActivity : AppCompatActivity(), RegisterView {
    private lateinit var preferences: Preferences

    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Pesan"
            message = msg ?: ""
        }.show()

        // Jika Sukses Lanjut ke halaman Register Upload Photo
        intent = Intent(this, RegisterUploadPhotoActivity::class.java)
        startActivity(intent)
    }

    override fun onErrorRegister(msg: String?) {
        alert {
            title = "Gagal"
            message = msg ?: ""
        }.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Call a Function Presenter
        callPresenter()

        // Function Back button
        backButton()

        // Shared Preferences
        preferences = Preferences(this)
    }

    private fun callPresenter() {
        val registerPresenter = RegisterPresenter(this)
        btnRegister.setOnClickListener {
            val sFullName = et_fullname.text.toString()
            val sPassword = et_password.text.toString()
            val sEmail = et_email.text.toString()
            val sProfession = et_profession.text.toString()

            if (sFullName == "") {
                et_fullname.error = "Silahkan isi Full Name"
                et_fullname.requestFocus()
            } else if (sPassword == "" && sPassword.length == 8) {
                et_password.error = "Silahkan isi Password"
                et_password.requestFocus()
            } else if (sEmail == "") {
                et_email.error = "Silahkan isi Email"
                et_email.requestFocus()
            } else {
                registerPresenter.register(sFullName, sPassword, sEmail, sProfession)
            }
        }
    }

    private fun backButton() {
        btn_back.setOnClickListener {
            onBackPressed()
        }
    }
}