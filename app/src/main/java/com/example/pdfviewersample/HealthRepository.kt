package com.example.pdfviewersample

import com.example.pdfviewersample.model.HealthReports
import com.example.pdfviewersample.model.LoginRequest
import com.example.pdfviewersample.model.LoginResponse
import retrofit2.Call


interface HealthRepository {

    fun getDiagnosticReport(requestId: String, authToken: String?): Call<HealthReports>
    fun getAuthToken(username: String, password: String): Call<LoginResponse>

}

class HealthRepositoryImpl(private val healthApis: HealthApis): HealthRepository {
    override fun getDiagnosticReport(requestId: String, authToken: String?): Call<HealthReports> {
        return healthApis.getDiagnosticReport(requestId, authToken)
    }

    override fun getAuthToken(username: String, password: String): Call<LoginResponse> {
        return  healthApis.getAuthToken(LoginRequest(username, password))
    }

}