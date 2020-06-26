package com.example.pdfviewersample.application

import android.app.Application
import com.example.pdfviewersample.networkModule
import com.example.pdfviewersample.pdfModule
import com.example.pdfviewersample.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class PdfViewerApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@PdfViewerApp)
            loadKoinModules(listOf(networkModule, pdfModule, repositoryModule))
        }
    }
}