package com.example.tugas18.service

import com.example.tugas18.model.UserResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

object NetworkConfig {

    // set interceptor
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.201.86:3000/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun serviceUser() = getRetrofit().create(RegisterService::class.java)

    /*interface Users {
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
    }*/
}