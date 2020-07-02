package com.example.pdfviewersample.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("entry") val entry: List<DataEntry>,
    @SerializedName("id") val id: String,
    @SerializedName("resourceType") val resourceType: String,
    @SerializedName("type") val type: String
)