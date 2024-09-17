package com.example.letterboxclone.domain.repository

import com.example.letterboxclone.data.MovieApi
import com.example.letterboxclone.domain.movie.MovieDetailResponse
import com.example.letterboxclone.domain.movie.MovieResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
) {
    suspend fun getPopularMovies(apiKey: String, page: Int): MovieResponse {
        return movieApi.getPopularMovies(apiKey = apiKey, page = page)
    }

    suspend fun getMovieDetails(apiKey: String, id: Int, token:String): MovieDetailResponse {
        return movieApi.getMovieDetails(apiKey = apiKey, movieId = id, authorization = token)
    }

}
