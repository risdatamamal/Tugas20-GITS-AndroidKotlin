package com.example.tugas18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rv_mentors: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Tugas 18"

        rv_mentors = findViewById(R.id.rv_mentors)
        rv_mentors.setHasFixedSize(true)
    }
}