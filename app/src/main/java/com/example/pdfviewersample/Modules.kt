package com.example.pdfviewersample

import com.example.pdfviewersample.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pdfModule = module {
    viewModel {  MainActivityViewModel(get()) }
}