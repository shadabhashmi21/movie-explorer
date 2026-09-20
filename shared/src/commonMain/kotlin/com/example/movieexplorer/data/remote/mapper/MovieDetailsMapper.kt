package com.example.movieexplorer.data.remote.mapper

import com.example.movieexplorer.data.remote.dto.MovieDetailsDto
import com.example.movieexplorer.domain.model.MovieDetails

fun MovieDetailsDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        id = id,
        title = title,
        overview = overview,
        posterPath = poster_path,
        backdropPath = backdrop_path,
        releaseDate = release_date,
        voteAverage = vote_average,
        voteCount = vote_count,
        runtime = runtime,
        genres = genres.map { it.name },
        tagline = tagline
    )
}