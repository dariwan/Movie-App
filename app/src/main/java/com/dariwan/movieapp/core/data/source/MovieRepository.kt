package com.dariwan.movieapp.core.data.source

import com.dariwan.movieapp.core.data.NetworkBoundResource
import com.dariwan.movieapp.core.data.Resource
import com.dariwan.movieapp.core.data.source.remote.RemoteDataSource
import com.dariwan.movieapp.core.data.source.remote.network.ApiResponse
import com.dariwan.movieapp.core.data.source.remote.response.MoviesItem
import com.dariwan.movieapp.core.domain.model.Movie
import com.dariwan.movieapp.core.domain.repository.IMovieRepository
import com.dariwan.movieapp.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors,
): IMovieRepository {
    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MoviesItem>>(){
            override fun loadFromDB(): Flow<List<Movie>> {

            }

            override suspend fun createCall(): Flow<ApiResponse<List<MoviesItem>>> =
                remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<MoviesItem>) {

            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun setFavoritemovie(movie: Movie, state: Boolean) {
        TODO("Not yet implemented")
    }
}