package com.example.cattlediag.presentation.identify

import androidx.lifecycle.ViewModel
import com.example.cattlediag.data.Repository
import com.example.cattlediag.data.remote.request.AddSymptomsRequest

class IdentifyViewModel(private val repository: Repository) : ViewModel() {

    val test = repository.getSymptoms()

    fun postSymptom(request: AddSymptomsRequest) = repository.postSymptoms(request)
}