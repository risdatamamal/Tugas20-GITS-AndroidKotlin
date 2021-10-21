package com.example.tugas18.service

import com.example.tugas18.model.ResultRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterService {
    @FormUrlEncoded
    @POST("users/register")
    fun register(
        @Field("name") sFullName: String,
        @Field("password") sPassword: String,
        @Field("email") sEmail: String,
        @Field("profession") sProfession: String
    ) : Call<ResultRegister>
}