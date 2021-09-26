package com.example.tugas18.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas18.R

class EditMentorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_mentors)
        title = "Edit Mentor"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}