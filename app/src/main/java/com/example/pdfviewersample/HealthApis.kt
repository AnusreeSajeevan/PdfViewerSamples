package com.example.pdfviewersample

import com.example.pdfviewersample.model.HealthReports
import com.example.pdfviewersample.model.LoginRequest
import com.example.pdfviewersample.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface HealthApis {

    @GET("health-information/fetch/{request-id}")
    fun getDiagnosticReport(@Path("request-id") requestId: String, @Header("Authorization") authToken: String?): Call<HealthReports>


    @POST("sessions")
    fun getAuthToken(@Body loginRequest: LoginRequest): Call<LoginResponse>

}