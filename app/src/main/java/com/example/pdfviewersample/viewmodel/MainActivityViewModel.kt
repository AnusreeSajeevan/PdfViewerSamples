package com.example.pdfviewersample.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Environment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdfviewersample.utils.getPdfUrl
import com.example.pdfviewersample.utils.getViewPdfIntent
import java.io.File

class MainActivityViewModel(private val context: Context): ViewModel() {
    lateinit var file: File
    var renderInApp = MutableLiveData<Boolean>(false)

    fun displayPdfUsingDefaultApp(): Intent {
        file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)?.absolutePath + "/" + getPdfUrl())
        return getViewPdfIntent(context, file)
    }
}