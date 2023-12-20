package com.example.cattlediag.data.remote.response

import com.google.gson.annotations.SerializedName

data class Symptoms(

	@field:SerializedName("Symptoms")
	val symptoms: List<SymptomsItem?>? = null
)

data class SymptomsItem(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("animal_id")
	val animalId: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
