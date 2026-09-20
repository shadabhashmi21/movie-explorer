package com.example.movieexplorer.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsDto(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val backdrop_path: String?,
    val release_date: String,
    val vote_average: Double,
    val vote_count: Int,
    val runtime: Int?,
    val genres: List<GenreDto>,
    val tagline: String?
)

@Serializable
data class GenreDto(
    val id: Int,
    val name: String
)