package com.example.tugas18.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tugas18.R
import com.example.tugas18.model.DataMentors

class MentorsAdapter(private val listMentors: List<DataMentors>) : RecyclerView.Adapter<MentorsAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindMentors(get: DataMentors) {
//            itemView.tv_list_name_mentors.text = get.name
//            itemView.tv_list_profession_mentors.text = get.profession
//            itemView.tv_list_email_mentors.text = get.email
//            Glide.with(itemView).load(get.profile).apply(RequestOptions().override(55, 55)).into(itemView.iv_photo_list_movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_mentors, parent, false)
        return ListViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindMentors(listMentors[position])
    }

    override fun getItemCount(): Int {
        return listMentors.size
    }
}