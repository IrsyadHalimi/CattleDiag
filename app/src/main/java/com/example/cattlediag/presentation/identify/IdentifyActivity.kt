package com.example.cattlediag.presentation.identify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.cattlediag.R
import com.example.cattlediag.databinding.ActivityIdentifyBinding
import com.example.cattlediag.presentation.result.ResultActivity

class IdentifyActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityIdentifyBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupSpinner()
        setupAction()
    }
    private fun setupAction() {
        binding.btnConfirm.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupSpinner() {
        val animal = resources.getStringArray(R.array.Animal)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, animal)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@IdentifyActivity,
                        getString(R.string.selected_item) + " " + "" + animal[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}