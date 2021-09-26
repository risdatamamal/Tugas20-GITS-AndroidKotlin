package com.example.tugas18.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R

class CreateMentorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_mentors)
        title = "Tambah Mentor"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}