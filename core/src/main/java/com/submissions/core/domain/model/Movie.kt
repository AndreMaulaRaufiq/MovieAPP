package com.submissions.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val title: String,
    val releaseDate: String,
    val voteAverage: Double,
    val isFavorite: Boolean,
) : Parcelable