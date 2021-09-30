package com.example.tugas18.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas18.R
import com.example.tugas18.adapter.MentorsAdapter
import com.example.tugas18.model.MentorResponse
import com.example.tugas18.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateMentorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_mentors)
        title = "Tambah Mentor"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        NetworkConfig().getService()
            .createMentorsList()
            .enqueue(object : Callback<MentorResponse> {
                override fun onResponse(
                    call: Call<MentorResponse>,
                    response: Response<MentorResponse>
                ) {
                    rv_mentors.layoutManager = LinearLayoutManager(this@CreateMentorActivity)
                    val listMentorsAdapter = MentorsAdapter(response.body()!!.mentors)
                    rv_mentors.adapter = listMentorsAdapter
                }

                override fun onFailure(call: Call<MentorResponse>, t: Throwable) {
                    Toast.makeText(this@CreateMentorActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}