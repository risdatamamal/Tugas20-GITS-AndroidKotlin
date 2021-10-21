package com.example.tugas18.presenter

import com.example.tugas18.model.ResultLogin
import com.example.tugas18.service.NetworkConfig
import com.example.tugas18.view.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView: LoginView) {
    fun login(sEmail: String, sPassword: String) {
        NetworkConfig.serviceUserLogin()
            .login(sEmail, sPassword)
            .enqueue(object: Callback<ResultLogin> {
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorRegister(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    if (response.body()?.status == 200) {
                        loginView.onSuccessRegister(response.message())
                    } else {
                        loginView.onErrorRegister(response.message())
                    }
                }
            })
    }
}