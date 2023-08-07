package com.example.retrofitdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class  ApiService private constructor(){
    var baseurl = "https://reqres.in/api"
    private val api: ApiInterface
    init {
        val retrofit = Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build()

        api = retrofit.create(ApiInterface::class.java)

    }
    fun getApi(): ApiInterface{
        return api
    }
    companion object{
        @get:Synchronized
        var instance : ApiService?= null
            get() {
                if (field==null){
                    field = ApiService()
                }
                return field
            }
            private set
    }

}