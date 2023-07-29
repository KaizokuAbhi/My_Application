package com.example.myapplication.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.TAG
import com.example.myapplication.models.NewsResponse
import com.example.myapplication.repositories.NewsApiRepository
import com.example.myapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsApiViewModel @Inject constructor(val repository: NewsApiRepository):ViewModel() {
    val breakingNews:MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private var breakingNewsPage=1

    val categoryNews:MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private var categoryNewsPage=1

    val searchNews:MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    private var searchNewsPage=1

    var country="in"


    fun getBreakingNews(countryCode: String = country) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        try {
            val response = repository.getBreakingNews(countryCode, breakingNewsPage)
            breakingNews.postValue(handleBreakingNewsResponse(response))
        }catch (e:Exception){
            e.printStackTrace()
            breakingNews.postValue(Resource.Failed(e.message.toString()))
        }
    }
    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        Log.d(TAG, "handleBreakingNewsResponse: ${response.message()}")
        return Resource.Failed(response.message())

    }
    fun getNewsByCategory(category:String,countryCode: String=country) = viewModelScope.launch {
        categoryNews.postValue(Resource.Loading())
        try {
            val response = repository.getCategoryNews(countryCode, category = category,categoryNewsPage)
            categoryNews.postValue(handleCategoryNewsResponse(response))
        }catch (e:Exception){
            e.printStackTrace()
            categoryNews.postValue(Resource.Failed("Error"))
            Log.d(TAG, "getNewsByCategory: ${e.message.toString()}")
        }
    }
    private fun handleCategoryNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        Log.d(TAG, "handleCategoryNewsResponse: ${response.message()}")
        return Resource.Failed(response.message())
    }
    fun getSearchNews(q: String) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        try {
            val response = repository.searchNews(q, searchNewsPage)
            searchNews.postValue(handleSearchNewsResponse(response))
        }catch (e:Exception){
            e.printStackTrace()
            searchNews.postValue(Resource.Failed("Error"))
        }
    }
    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        Log.d(TAG, "handleSearchNewsResponse: ${response.message()}")
        return Resource.Failed(response.message())
    }
}