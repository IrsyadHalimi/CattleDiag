package com.example.cattlediag.data.remote.response

import com.google.gson.annotations.SerializedName

data class DiseasesResponse(

	@field:SerializedName("DiseasesResponse")
	val diseasesResponse: List<DiseasesResponseItem?>? = null
)

data class DiseasesResponseItem(

	@field:SerializedName("treatment")
	val treatment: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("animal_id")
	val animalId: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("desease_img")
	val deseaseImg: String? = null,

	@field:SerializedName("prevention")
	val prevention: String? = null
)
