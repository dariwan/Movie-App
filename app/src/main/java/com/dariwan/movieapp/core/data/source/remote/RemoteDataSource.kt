package com.dariwan.movieapp.core.data.source.remote

import com.dariwan.movieapp.core.data.source.remote.network.ApiResponse
import com.dariwan.movieapp.core.data.source.remote.network.ApiService
import com.dariwan.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllMovie(): Flow<ApiResponse<List<Movie>>>{
        //get data from api
        return flow {
            try {
                val response = apiService.
            }
        }
    }
}