package com.example.myapplication.api

import com.example.myapplication.models.NewsResponse
import com.example.myapplication.utils.Constants.apikey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/everything")
    suspend fun searchNews(@Query("q")q:String,
                           @Query("page")page:Int,
                           @Query("apikey")key:String=apikey
                           ):Response<NewsResponse>
    @GET("/v2/breakingNews")
    suspend fun breakingNews(@Query("country")country:String="in",
                             @Query("page")page:Int=1,
                             @Query("apikey")key:String=apikey
                                ):Response<NewsResponse>
    @GET("/v2/breakingNews")
    suspend fun categoryNews(@Query("country")country:String="in",
                             @Query("category")category:String?=null,
                             @Query("page")page:Int=1,
                             @Query("apikey")key:String=apikey
                             ):Response<NewsResponse>
}