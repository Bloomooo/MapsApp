package com.ez.mapsggez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    private val keyAPI = "AIzaSyBv3E37Cb2-IHNf3COvDZb5cDNsvsvvi8g"
    private val urlAPI = "https://maps.googleapis.com/maps/api/staticmap?center=40.714728,-73.998672&zoom=12&size=400x400&key=&signature=$keyAPI"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ggez = getGgez()

        GlobalScope.launch {
            val result = ggez
            if (result != null)

                Log.d("ayush: ", result.body().toString())
        }
    }

    private fun getGgez():Retrofit{
        return Retrofit.Builder().baseUrl(urlAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    interface QuotesApi {
        @GET("/quotes")
        suspend fun getQuotes() : Response<String>
    }

}