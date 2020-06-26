package com.example.pdfviewersample

import com.example.pdfviewersample.viewmodel.HapiFhirActivityViewModel
import com.example.pdfviewersample.viewmodel.MainActivityViewModel
import com.example.pdfviewersample.viewmodel.WebViewActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val pdfModule = module {
    viewModel {  MainActivityViewModel(get()) }
    viewModel {  WebViewActivityViewModel() }
    viewModel {  HapiFhirActivityViewModel(get()) }
}

val networkModule = module {
    single { NetworkManager(get()) }
    single { get<NetworkManager>().createNetworkClient() }
    single { get<Retrofit>().create(HealthApis::class.java) }
}

val repositoryModule = module {
    factory { HealthRepositoryImpl(get()) as HealthRepository }
}