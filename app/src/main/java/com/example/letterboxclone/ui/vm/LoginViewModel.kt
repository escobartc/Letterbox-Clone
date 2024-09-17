package com.example.letterboxclone.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letterboxclone.domain.Constants
import com.example.letterboxclone.domain.movie.MovieResponse
import com.example.letterboxclone.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _popularMovies = MutableLiveData<MovieResponse>()
    val popularMovies: LiveData<MovieResponse> get() = _popularMovies

    private val _loadingPopular = MutableLiveData<Boolean>()
    val loadingPopular: LiveData<Boolean> get() = _loadingPopular

    private val _currentBackdrop = MutableLiveData<String>()
    val currentBackdrop: LiveData<String> get() = _currentBackdrop

    private val _currentTitle = MutableLiveData<String>()
    val currentTitle: LiveData<String> get() = _currentTitle

    init {
        startFetchingPopularMovies(Constants.API_KEY)
    }

    private fun startFetchingPopularMovies(apiKey: String) {
        viewModelScope.launch {
            while (true) {
                val page = Random.nextInt(1, 101)
                fetchPopularMovies(apiKey, page)
                delay(10000) // 10 seconds
            }
        }
    }

    private fun fetchPopularMovies(apiKey: String, page: Int) {
        viewModelScope.launch {
            _loadingPopular.value = true
            try {
                val response = repository.getPopularMovies(apiKey, page)
                _popularMovies.postValue(response)
                selectRandomMovie(response)
            } catch (e: Exception) {
                // Handle the exception
            } finally {
                _loadingPopular.postValue(false)
            }
        }
    }

    private fun selectRandomMovie(response: MovieResponse) {
        val movies = response.results
        if (movies.isNotEmpty()) {
            val randomMovie = movies.random()
            fetchMovieDetails(randomMovie.id)
        }
    }

    private fun fetchMovieDetails(movieId: Int) {
        viewModelScope.launch {
            try {
                val movieDetails = repository.getMovieDetails(
                    apiKey = Constants.API_KEY,
                    id = movieId,
                    token = Constants.HEADER
                )
                _currentBackdrop.postValue(movieDetails.backdropPath)
                _currentTitle.postValue(movieDetails.title)
            } catch (e: Exception) {
                // Handle the exception
            }
        }
    }
}

