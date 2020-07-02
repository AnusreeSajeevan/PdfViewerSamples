package com.example.pdfviewersample.model

import com.google.gson.annotations.SerializedName

data class HealthReports(
    @SerializedName("entries") val entries: List<Entry>,
    @SerializedName("limit") val limit: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("size") val size: Int
)