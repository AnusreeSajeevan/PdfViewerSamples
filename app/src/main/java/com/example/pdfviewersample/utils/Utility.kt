package com.example.pdfviewersample.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import com.example.pdfviewersample.BuildConfig
import java.io.File


fun getViewPdfIntent(context: Context, file: File): Intent {
    var pdfIntent = Intent(Intent.ACTION_VIEW)
    var uri =     FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file);

    pdfIntent.setDataAndType(uri, "application/pdf")
    pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    return Intent.createChooser(pdfIntent, "Open File");
}

fun getPdfUrl(): String {
    return "https://mindorks.s3.ap-south-1.amazonaws.com/courses/MindOrks_Android_Online_Professional_Course-Syllabus.pdf"
}