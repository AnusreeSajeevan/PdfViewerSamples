package com.example.pdfviewersample.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import com.example.pdfviewersample.BuildConfig
import com.example.pdfviewersample.model.DataEntry
import com.example.pdfviewersample.model.Entry
import java.io.File

const val KEY_DIAGNOSTIC_REPORT = "DiagnosticReport"
const val KEY_CONDITION = "Condition"

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

fun getDataEntries(bundle: List<Entry>?): ArrayList<DataEntry> {
    var dataEntries : ArrayList<DataEntry> = arrayListOf()
    bundle?.let {
        bundle.forEach {
            (it.data.entry).forEach {
                dataEntries.add(it)
            }
        }
    }
    return dataEntries
}


fun getData(bundle: List<Entry>?, key: String):List<DataEntry>  {
    return getDataEntries(bundle).filter { it.resource?.resourceType == key }
}