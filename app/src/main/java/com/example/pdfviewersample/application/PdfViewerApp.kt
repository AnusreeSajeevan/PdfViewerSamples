package com.example.pdfviewersample.application

import android.app.Application
import com.example.pdfviewersample.pdfModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PdfViewerApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@PdfViewerApp)
            modules(pdfModule)
        }
    }
}