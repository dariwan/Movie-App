package com.dariwan.movieapp.core.domain.usecase

import com.dariwan.movieapp.core.data.Resource
import com.dariwan.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoritemovie(movie: Movie, state: Boolean)
}