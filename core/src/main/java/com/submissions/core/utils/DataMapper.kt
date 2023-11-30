package com.submissions.core.utils

import com.submissions.core.data.source.local.entity.MovieEntity
import com.submissions.core.data.source.remote.response.ItemResult
import com.submissions.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<ItemResult>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                it.id,
                it.overview,
                it.popularity,
                it.posterPath,
                it.title,
                it.releaseDate,
                it.voteAverage,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                it.movieId,
                it.overview,
                it.popularity,
                it.posterPath,
                it.title,
                it.releaseDate,
                it.voteAverage,
                it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        input.movieId,
        input.overview,
        input.popularity,
        input.posterPath,
        input.title,
        input.releaseDate,
        input.voteAverage,
        input.isFavorite
    )
}