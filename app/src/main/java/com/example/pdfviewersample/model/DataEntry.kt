package com.example.pdfviewersample.model

import com.google.gson.annotations.SerializedName

data class DataEntry(
    @SerializedName("fullUrl") val fullUrl: String,
    @SerializedName("resource") val resource: Resource
)