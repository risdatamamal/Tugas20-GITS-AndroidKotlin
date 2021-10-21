package com.example.tugas18.presenter

import com.example.tugas18.model.ResultRegister
import com.example.tugas18.service.NetworkConfig
import com.example.tugas18.view.RegisterView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {
    fun register(sFullName: String, sPassword: String, sEmail: String, sProfession: String) {
        NetworkConfig.serviceUserRegister()
            .register(sFullName, sPassword, sEmail, sProfession)
            .enqueue(object: Callback<ResultRegister> {
                override fun onFailure(call: Call<ResultRegister>, t: Throwable) {
                    registerView.onErrorRegister(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultRegister>, response: Response<ResultRegister>) {
                    if (response.body()?.status == 200) {
                        registerView.onSuccessRegister(response.message())
                    } else {
                        registerView.onErrorRegister(response.message())
                    }
                }
            })
    }
}