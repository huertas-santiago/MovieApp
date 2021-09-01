package com.example.movieapp.presentataion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.liveData
import com.example.movieapp.core.Resource
import com.example.movieapp.repository.MovieRepository
import java.lang.Exception

class MovieViewModel(private val repo: MovieRepository): ViewModel() {
    fun fetchMainScreenMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {


            emit(Resource.Success(Triple(repo.getUpcomingMovies(),repo.getTopRatedMovies(),repo.getPopularityMovies())))
        }catch (e : Exception){
            emit(Resource.Failure(e))
        }
    }
}

class MovieViewModelFactory(private val repo: MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}