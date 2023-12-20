package com.example.cattlediag.data.remote.response

import com.google.gson.annotations.SerializedName

data class Diagnose(

	@field:SerializedName("error")
	val error: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)
