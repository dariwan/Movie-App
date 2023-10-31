package com.dariwan.movieapp.core.data.source.remote

import android.util.Log
import com.dariwan.movieapp.core.data.source.remote.network.ApiResponse
import com.dariwan.movieapp.core.data.source.remote.network.ApiService
import com.dariwan.movieapp.core.data.source.remote.response.MoviesItem
import com.dariwan.movieapp.core.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllMovie(): Flow<ApiResponse<List<MoviesItem>>>{
        //get data from api
        return flow {
            try {
                val response = apiService.getList()
                val data = response.results
                if (data.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}