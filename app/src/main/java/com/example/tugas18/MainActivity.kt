package com.example.tugas18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas18.adapter.MentorsAdapter
import com.example.tugas18.model.MentorResponse
import com.example.tugas18.service.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rv_mentors: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Tugas 18"

        rv_mentors = findViewById(R.id.rv_mentors)
        rv_mentors.setHasFixedSize(true)

        NetworkConfig().getService()
            .getMentorsList()
            .enqueue(object : Callback<MentorResponse> {
                override fun onResponse(
                    call: Call<MentorResponse>,
                    response: Response<MentorResponse>
                ) {
                    rv_mentors.layoutManager = LinearLayoutManager(this@MainActivity)
                    val listMentorsAdapter = MentorsAdapter(response.body()!!.mentors)
                    rv_mentors.adapter = listMentorsAdapter
                }

                override fun onFailure(call: Call<MentorResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
    }
}