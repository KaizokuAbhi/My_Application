package com.example.myapplication.repositories

import com.example.myapplication.api.NewsApi
import javax.inject.Inject

class NewsApiRepository @Inject constructor(private val newsApi: NewsApi){
    suspend fun getBreakingNews(country:String,page:Int)=
        newsApi.breakingNews(country,page)
    suspend fun getCategoryNews(country: String,category:String,page: Int)=
        newsApi.categoryNews(country,category,page)
    suspend fun searchNews(q:String,page: Int)=
        newsApi.searchNews(q,page)
}