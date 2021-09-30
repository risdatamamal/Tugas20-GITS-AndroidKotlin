package com.example.tugas18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas18.adapter.MentorsAdapter
import com.example.tugas18.model.MentorResponse
import com.example.tugas18.service.NetworkConfig
import com.example.tugas18.view.CreateMentorActivity
import com.example.tugas18.view.EditMentorActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_mentors.*
import kotlinx.android.synthetic.main.list_mentors.view.*
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

        btn_create.setOnClickListener { view ->
            val intentCreateMentor = Intent(this, CreateMentorActivity::class.java)
            startActivity(intentCreateMentor)
        }

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