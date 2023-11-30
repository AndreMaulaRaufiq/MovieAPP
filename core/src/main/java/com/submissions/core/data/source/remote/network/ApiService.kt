package com.submissions.core.data.source.remote.network

import com.submissions.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/top_rated?api_key=bd4ed1af66133824c0e9be9e9f0e5de3")
    suspend fun getList(): MovieResponse
}