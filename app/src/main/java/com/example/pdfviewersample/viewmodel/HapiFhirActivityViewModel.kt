package com.example.pdfviewersample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pdfviewersample.HealthRepository
import com.example.pdfviewersample.utils.PayloadLiveData
import fetch

class HapiFhirActivityViewModel(val healthRepository: HealthRepository): ViewModel() {

    companion object {
        const val REQUEST_ID = "5b16a678-ac53-4d94-9025-20057d4ebfff"
        const val AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiRE9DVE9SIiwiaXNWZXJpZmllZCI6dHJ1ZSwidXNlcm5hbWUiOiJsYWtzaG1pIn0.r74QH84_BBDZHxZY6x0KEJ3HWiVK5p-_mqYAcFZz3yM"
    }

    var healthDataResponse = PayloadLiveData<Void>()

    fun getHealthInfo() {
        healthDataResponse.fetch(healthRepository.getDiagnosticReport(REQUEST_ID, AUTH_TOKEN))
    }

}