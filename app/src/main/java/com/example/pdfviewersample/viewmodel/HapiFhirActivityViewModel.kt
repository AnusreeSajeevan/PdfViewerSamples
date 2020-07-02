package com.example.pdfviewersample.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.pdfviewersample.HealthRepository
import com.example.pdfviewersample.model.HealthReports
import com.example.pdfviewersample.model.LoginResponse
import com.example.pdfviewersample.utils.PayloadLiveData
import fetch

class HapiFhirActivityViewModel(private val healthRepository: HealthRepository): ViewModel() {

    companion object {
        const val REQUEST_ID = "5b16a678-ac53-4d94-9025-20057d4ebfff"
        const val USERNAME = "lakshmi"
        const val PASSWORD = "password"
    }

    var authToken = ObservableField<String>()
    var healthDataResponse = PayloadLiveData<HealthReports>()
    var authResponse = PayloadLiveData<LoginResponse>()

    fun getHealthInfo() {
        healthDataResponse.fetch(healthRepository.getDiagnosticReport(REQUEST_ID, authToken.get()))
    }

    fun getAuthToken() {
        authResponse.fetch(healthRepository.getAuthToken(USERNAME, PASSWORD))
    }

}