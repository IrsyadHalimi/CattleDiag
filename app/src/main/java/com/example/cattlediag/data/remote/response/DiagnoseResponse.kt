package com.example.cattlediag.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class DiagnoseResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("searchData")
	val searchData: List<SearchData>? = null,
) {
	@Parcelize
	data class SearchData(
		@field:SerializedName("id")
		val id: String? = null,
		@field:SerializedName("animal_id")
		val animalId: String? = null,
		@field:SerializedName("name")
		val name: String? = null,
		@field:SerializedName("description")
		val description: String? = null,
		@field:SerializedName("prevention")
		val prevention: String? = null,
		@field:SerializedName("treatment")
		val treatment: String? = null,
		@field:SerializedName("desease_img")
		val deseaseImg: String? = null,
	): Parcelable
}
