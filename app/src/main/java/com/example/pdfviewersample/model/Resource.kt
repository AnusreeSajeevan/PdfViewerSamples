package com.example.pdfviewersample.model

import com.example.pdfviewersample.BR
import com.example.pdfviewersample.IDataBindingModel
import com.example.pdfviewersample.R
import com.google.gson.annotations.SerializedName

data class Resource(
    @SerializedName("code") val code: Code,
    @SerializedName("conclusion") val conclusion: String?,
    @SerializedName("effectiveDateTime") val effectiveDateTime: String?,
    @SerializedName("issued") val issued: String?,
    @SerializedName("performer") val performer: List<Performer>?,
    @SerializedName("presentedForm") val presentedForm: List<PresentedForm>?,
    @SerializedName("resourceType") val resourceType: String,
    @SerializedName("status") val status: String?,
    @SerializedName("subject") val subject: Subject
): IDataBindingModel {
    override fun layoutResId(): Int {
        return R.layout.entry_item
    }

    override fun dataBindingVariable(): Int {
        return BR.dataEntry
    }
}