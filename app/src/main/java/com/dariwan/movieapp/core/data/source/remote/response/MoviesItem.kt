package com.dariwan.movieapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MoviesItem (
    @field:SerializedName("backdrop_path")
    val backdrop_path: String,

    @field:SerializedName("original_language")
    val original_language: String,

    @field:SerializedName("original_title")
    val original_title: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("popularity")
    val popularity: Int,

    @field:SerializedName("poster_path")
    val poster_path: String,

    @field:SerializedName("release_date")
    val release_date: String,

    @field:SerializedName("isFavorite")
    val isFavorite: Boolean,
)