package com.example.pdfviewersample.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Environment
import androidx.lifecycle.ViewModel
import com.example.pdfviewersample.utils.getViewPdfIntent
import java.io.File

class MainActivityViewModel(private val context: Context): ViewModel() {
    companion object {
        const val pdfFileName = "/sample-pdf-file.pdf"
    }

    lateinit var file: File

    fun displayPdfUsingDefaultApp(): Intent {
        file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath + pdfFileName)
        return getViewPdfIntent(context, file)
    }
}