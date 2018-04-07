package com.example.rubayet.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var messageType: String? = null
    var userID: String? = null
    var decodeId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*ApiService.create().getValidUserData("mybdjobs").enqueue(object : Callback<ValidUserModel> {
            override fun onResponse(call: Call<ValidUserModel>?, response: Response<ValidUserModel>?) {
                messageType = response?.body()?.messageType
                userID = response?.body()?.userID
                decodeId = response?.body()?.decodeId
                Toast.makeText(applicationContext,"messageType = $messageType , UserID = ${response?.body()?.userID},  decodeId = $decodeId",Toast.LENGTH_LONG).show()
                Log.d("messageTyperesponse", "messageType = $messageType , UserID = $userID,  decodeId = $decodeId")
            }

            override fun onFailure(call: Call<ValidUserModel>?, t: Throwable?) {
                Log.d("messageTyperesponse", "got error: ${t.toString()}")
            }


        })*/

        ApiService.create().getNewsList("us","business","b16d2555b99145dcb1fb8c6db1134f9d").enqueue(object :Callback<NewsModel>{
            override fun onFailure(call: Call<NewsModel>?, t: Throwable?) {
                Log.d("messageTyperesponse", "got error: ${t.toString()}")
            }

            override fun onResponse(call: Call<NewsModel>?, response: Response<NewsModel>?) {
                Log.d("messageTyperesponse", "lentgth: ${response?.body()?.articles?.size}")
                for(article in response?.body()?.articles!!){
                    Log.d("messageTyperesponse", "description: ${article.description}")

                }

            }

        })

    }
}
