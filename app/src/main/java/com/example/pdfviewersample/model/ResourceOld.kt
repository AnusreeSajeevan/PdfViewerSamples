package com.example.pdfviewersample.model

data class ResourceOld(
    val code: Code,
    val conclusion: String,
    val effectiveDateTime: String,
    val issued: String,
    val performer: List<Performer>,
    val presentedForm: List<PresentedForm>,
    val resourceType: String,
    val status: String,
    val subject: Subject
)