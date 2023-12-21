package com.example.cattlediag.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.cattlediag.data.remote.request.AddSymptomsRequest
import com.example.cattlediag.data.remote.response.DiagnoseResponse
import com.example.cattlediag.data.remote.response.SymptomsItem
import com.example.cattlediag.data.retrofit.ApiService
import com.example.cattlediag.utils.Result

class Repository private constructor(
    private val apiService: ApiService,
){

    private val TAG = "Repository-Error"

    fun getSymptoms(): LiveData<Result<List<SymptomsItem>>> = liveData {
        emit(Result.Loading)
        try {
            val client = apiService.getSymptoms()
            emit(Result.Success(client))
        } catch (e: Exception) {
            Log.e(TAG, e.localizedMessage)
            emit(Result.Error(e.localizedMessage))
        }
    }

    fun postSymptoms(request: AddSymptomsRequest): LiveData<Result<DiagnoseResponse>> = liveData {
        emit(Result.Loading)
        try {
            val client = apiService.addSymptom(request)
            emit(Result.Success(client))
        } catch (e: Exception) {
            Log.e(TAG, e.localizedMessage)
            emit(Result.Error(e.localizedMessage))
        }
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            apiService: ApiService
        ): Repository =
            instance ?: synchronized(this) {
                instance?: Repository(apiService)
            }.also { instance = it }
    }
}