package com.example.cattlediag.di

import android.content.Context
import com.example.cattlediag.data.Repository
import com.example.cattlediag.data.retrofit.ApiConfig
import com.example.cattlediag.data.retrofit.ApiService

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService)
    }
}