package com.example.pdfviewersample

import retrofit2.Call


interface HealthRepository {

    fun getDiagnosticReport(requestId: String, authToken: String?): Call<Void>

}

class HealthRepositoryImpl(private val healthApis: HealthApis): HealthRepository {
    override fun getDiagnosticReport(requestId: String, authToken: String?): Call<Void> {
        return healthApis.getDiagnosticReport(requestId, authToken)
    }

}