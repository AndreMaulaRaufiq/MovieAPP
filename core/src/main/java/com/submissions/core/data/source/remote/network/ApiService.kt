package com.submissions.core.data.source.remote.network

import com.submissions.core.data.source.remote.response.ResponseMovies
import retrofit2.http.GET

interface ApiService {
    @GET("movie/top_rated?api_key=89994521cf56841c2ffc565717829e9e")
    suspend fun getList(): ResponseMovies
}