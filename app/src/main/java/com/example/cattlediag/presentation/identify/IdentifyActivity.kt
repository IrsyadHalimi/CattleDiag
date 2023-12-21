package com.example.cattlediag.presentation.identify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import com.example.cattlediag.R
import com.example.cattlediag.ViewModelFactory
import com.example.cattlediag.data.remote.request.AddSymptomsRequest
import com.example.cattlediag.databinding.ActivityIdentifyBinding
import com.example.cattlediag.presentation.result.ResultActivity
import com.example.cattlediag.utils.Result

class IdentifyActivity : AppCompatActivity() {

    private val vm by viewModels<IdentifyViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private var animalId = ""
    private var symptomDesc = ""

    private val binding by lazy {
        ActivityIdentifyBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        vm.test.observe(this) { result ->
//            when (result) {
//                is Result.Error -> println("ERROR: ${result.error}")
//                Result.Loading -> println("LOADING...")
//                is Result.Success -> println("SUCCESS: ${result.data}")
//            }
//        }

        setupSpinner()
        setupAction()
    }
    private fun setupAction() {
        binding.btnConfirm.setOnClickListener{
            symptomDesc = binding.edDescription.text.toString()

            if (animalId.isNotEmpty() && symptomDesc.isNotEmpty()) {
                val request = AddSymptomsRequest(
                    animalId = animalId,
                    symptomDesc = symptomDesc
                )
                vm.postSymptom(request).observe(this) { result ->
                    when (result) {
                        is Result.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, result.error, Toast.LENGTH_SHORT).show()
                        }
                        Result.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Result.Success -> {
                            binding.progressBar.visibility = View.GONE

                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra("KEY_DIAGNOSE", result.data.searchData?.get(0))
                            startActivity(intent)
                            finish()
                        }

                    }
                }
            }

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
                    animalId = animal[position]
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