package com.example.pdfviewersample.model

import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("data") val data: Data,
    @SerializedName("hipId") val hipId: String,
    @SerializedName("hipName") val hipName: String,
    @SerializedName("status") val status: String
)