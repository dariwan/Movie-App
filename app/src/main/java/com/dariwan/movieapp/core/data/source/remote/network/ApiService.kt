package com.dariwan.movieapp.core.data.source.remote.network

import com.dariwan.movieapp.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular")
    suspend fun getList() : ListMovieResponse
}