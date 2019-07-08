package com.cz.weather.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "e4e4107b657a4a959f8133513190807"

//http://api.apixu.com/v1/current.json?key=e4e4107b657a4a959f8133513190807&q=Perth
interface WeatherAPIService {

    @GET("current.json?key=$API_KEY")
    fun getCurrentWeather(@Query("q") location: String): Call<Weather>

    companion object {

        operator fun invoke():WeatherAPIService{
            return Retrofit.Builder()
                .baseUrl("http://api.apixu.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(WeatherAPIService::class.java)
        }
    }
}