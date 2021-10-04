package com.example.tugas18.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(

	@field:SerializedName("data")
	val user: Data? = null,

	@field:SerializedName("status")
	val status: String? = null

) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("profession")
	val profession: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("email")
	val email: String? = null

) : Parcelable
