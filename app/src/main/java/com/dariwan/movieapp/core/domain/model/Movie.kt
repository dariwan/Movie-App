package com.dariwan.movieapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Int,
    val poster_path: String,
    val release_date: String,
    val isFavorite: Boolean
): Parcelable
