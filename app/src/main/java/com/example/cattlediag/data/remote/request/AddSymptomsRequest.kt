package com.example.cattlediag.data.remote.request

import com.google.gson.annotations.SerializedName

data class AddSymptomsRequest(
    @field:SerializedName("animalId")
    val animalId: String,
    @field:SerializedName("symptomDesc")
    val symptomDesc: String
)