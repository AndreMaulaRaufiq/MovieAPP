package com.submissions.movlist.di

import com.submissions.core.domain.usecase.MovieInteractor
import com.submissions.core.domain.usecase.MovieUseCase
import com.submissions.movlist.ui.detail.DetailViewModel
import com.submissions.movlist.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}