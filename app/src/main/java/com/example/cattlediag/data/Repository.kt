package com.example.cattlediag.data

import com.example.cattlediag.data.retrofit.ApiService

class Repository private constructor(
    private val apiService: ApiService,
){

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