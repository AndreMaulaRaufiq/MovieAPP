package com.submissions.movlist.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submissions.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovie().asLiveData()
}