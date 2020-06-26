package com.example.pdfviewersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.pdfviewersample.databinding.ActivityHapiFhirBinding
import com.example.pdfviewersample.viewmodel.HapiFhirActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HapiFhirActivity : AppCompatActivity() {

    lateinit var binding: ActivityHapiFhirBinding

    val viewModel: HapiFhirActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@HapiFhirActivity, R.layout.activity_hapi_fhir)
        initBinding()
        initObservers()

    }

    private fun initObservers() {
        viewModel.healthDataResponse.observe(this, Observer {
            it
        })
    }

    fun initBinding() {
        binding.viewModel = viewModel

    }
}
