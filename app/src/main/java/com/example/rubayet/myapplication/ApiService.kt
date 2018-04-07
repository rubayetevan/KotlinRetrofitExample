package com.example.rubayet.myapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {

    @GET("top-headlines")
    fun getNewsList(@Query("country") country: String, @Query("category") category: String,@Query("apiKey") apiKey: String): Call<NewsModel>


    /*@FormUrlEncoded
    @POST("mybdjobs/apps_b_checkValidUser.asp")
    fun getValidUserData(@Field("mobile") mobile: String): Call<ValidUserModel>*/


    companion object Factory {
        val BASE_URL = "https://newsapi.org/v2/"
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}