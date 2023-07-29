package com.example.myapplication.utils

sealed class Resource<T>(
    val data:T?=null,
    val message:String=""
) {
    class Success<T>(data:T):Resource<T>(data)
    class Failed<T>(message: String):Resource<T>(message=message)
    class Loading<T>():Resource<T>()
}