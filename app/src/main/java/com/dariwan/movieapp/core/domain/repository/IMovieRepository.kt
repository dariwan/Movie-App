package com.dariwan.movieapp.core.domain.repository

import com.dariwan.movieapp.core.data.Resource
import com.dariwan.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoritemovie(movie: Movie, state: Boolean)
}