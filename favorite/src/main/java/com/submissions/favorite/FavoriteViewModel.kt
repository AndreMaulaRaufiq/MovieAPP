package com.submissions.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submissions.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}