package com.example.movieexplorer.data.remote

import com.example.movieexplorer.data.remote.dto.MovieResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class MovieApi(
    private val httpClient: HttpClient
){
    suspend fun getTopRatedMovies(): MovieResponseDto {
        return httpClient
            .get("https://api.themoviedb.org/3/movie/top_rated") {
                url {
                    parameters.append(
                        "api_key",
                        "e3fa29ff3ccecf2807d0ae68d4c4265e"
                    )
                }
            }
            .body()
    }
}