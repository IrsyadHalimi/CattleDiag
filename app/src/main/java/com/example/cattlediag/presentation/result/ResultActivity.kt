package com.example.cattlediag.presentation.result

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.cattlediag.R
import com.example.cattlediag.data.remote.response.DiagnoseResponse
import com.example.cattlediag.databinding.ActivityResultBinding
import com.example.cattlediag.presentation.main.MainActivity

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val diagnose =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra("KEY_DIAGNOSE", DiagnoseResponse.SearchData::class.java)
            } else {
                @Suppress("DEPRECIATION")
                intent.getParcelableExtra("KEY_DIAGNOSE")
            }
        setupData(diagnose)
        setupAction()
    }

    private fun setupAction() {
        binding.btnResult.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupData(diagnose: DiagnoseResponse.SearchData?) {
        with(binding) {
            diagnose?.let {
                tvResultDesc.text = "Desc: ${it.description}"
                tvResultPreventation.text = "Prevention: ${it.prevention}"
                tvResultTreatment.text = "Treatment: ${it.treatment}"
                Glide.with(this@ResultActivity)
                    .load(it.deseaseImg)
                    .into(imgResult)
            }
        }
    }
}