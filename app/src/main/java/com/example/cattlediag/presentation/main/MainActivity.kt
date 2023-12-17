package com.example.cattlediag.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cattlediag.R
import com.example.cattlediag.databinding.ActivityMainBinding
import com.example.cattlediag.presentation.identify.IdentifyActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() {
        binding.btnMain.setOnClickListener{
            val intent = Intent(this, IdentifyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}