package com.dariwan.movieapp.core.di

import com.dariwan.movieapp.core.domain.usecase.MovieInteractor
import com.dariwan.movieapp.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieUsecase(movieInteractor: MovieInteractor): MovieUseCase
}