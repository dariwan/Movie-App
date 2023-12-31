package com.dariwan.movieapp.core.domain.usecase

import com.dariwan.movieapp.core.domain.model.Movie
import com.dariwan.movieapp.core.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {
    override fun getAllMovie() = movieRepository.getAllMovie()
    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoritemovie(movie: Movie, state: Boolean) = movieRepository.setFavoritemovie(movie, state)
}