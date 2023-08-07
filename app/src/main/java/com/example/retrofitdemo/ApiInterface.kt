package com.example.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("marvel")
    fun getData(): Call<MainDataModel>
}