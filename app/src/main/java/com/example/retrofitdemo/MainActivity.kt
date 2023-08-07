package com.example.retrofitdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShowData()


    }
    private fun  ShowData (){
        val call: Call<MainDataModel>? = ApiService.instance?.getApi()?.getData()
        call?.enqueue(object : Callback<MainDataModel?> {
            override fun onResponse(
                call: Call<MainDataModel?>,
                response: Response<MainDataModel?>,
            ) {
              val data= response.body()

                //Log.i("demourl",data.toString())
            }
            override fun onFailure(call: Call<MainDataModel?>, t: Throwable) {
                Log.i("demourl",t.message.toString())
            }
        })
    }

}