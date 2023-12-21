package com.example.cattlediag.data.retrofit

import com.example.cattlediag.data.remote.request.AddSymptomsRequest
import com.example.cattlediag.data.remote.response.DiagnoseResponse
import com.example.cattlediag.data.remote.response.SymptomsItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("symptoms")
    suspend fun getSymptoms(): List<SymptomsItem>

    @POST("diagnose")
    suspend fun addSymptom(@Body request: AddSymptomsRequest): DiagnoseResponse
}