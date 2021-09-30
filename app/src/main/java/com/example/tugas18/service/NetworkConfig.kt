package com.example.tugas18.service

import com.example.tugas18.model.MentorResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

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
            .baseUrl("http://192.168.18.10:8000/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): Mentors = getRetrofit().create(Mentors::class.java)

    interface Mentors {
        @GET("mentors")
        fun getMentorsList(): Call<MentorResponse>

        @POST("mentors")
        fun createMentorsList(): Call<MentorResponse>
    }

}