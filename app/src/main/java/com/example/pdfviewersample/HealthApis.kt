package com.example.pdfviewersample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface HealthApis {

    @GET("health-information/fetch/{request-id}")
    fun getDiagnosticReport(@Path("request-id") requestId: String, @Header("Authorization") authToken: String?): Call<Void>

}