package com.example.tugas18.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MentorResponse(

	@field:SerializedName("data")
	val mentors: List<DataMentors>,

) : Parcelable

@Parcelize
data class DataMentors(

	@field:SerializedName("profession")
	val profession: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("profile")
	val profile: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null

) : Parcelable
