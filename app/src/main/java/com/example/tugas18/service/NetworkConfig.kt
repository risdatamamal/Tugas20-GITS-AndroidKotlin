package com.example.tugas18.service

import com.example.tugas18.model.UserResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

class NetworkConfig {

    // set interceptor
    private fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:3000/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): Users = getRetrofit().create(Users::class.java)

    interface Users {
        @POST("users/register")
        fun postRegisterUser(): UserResponse

        @POST("users/login")
        fun postLoginUser(): UserResponse

        @PUT("users")
        fun putUpdateUser(): UserResponse

        @GET("users")
        fun getProfileUser(): UserResponse

        @POST("users/logout")
        fun postLogoutUser(): UserResponse
    }
}