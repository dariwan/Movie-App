package com.dariwan.movieapp.core.data.source.remote.network

import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular?language=en-US&page=1")
    suspend fun getList() :
}