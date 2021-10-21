package com.example.tugas18.service

import com.example.tugas18.model.ResultLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    @FormUrlEncoded
    @POST("users/login")
    fun login(
        @Field("email") sEmail: String,
        @Field("password") sPassword: String
    ) : Call<ResultLogin>
}