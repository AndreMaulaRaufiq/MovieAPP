package com.submissions.movlist.ui.detail

import androidx.lifecycle.ViewModel
import com.submissions.core.domain.model.Movie
import com.submissions.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}