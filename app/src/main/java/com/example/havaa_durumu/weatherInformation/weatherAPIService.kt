package com.example.havadurumuv10.havadurumubilgisi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface weatherAPIService {
    @GET("weather/getWeather?data.lang=tr")
    @Headers("authorization: apikey 6RkfJoBGmqnhdpQkGmiafZ:6VwuH2HhU47o0Z3xUpkFBc","content-type: application/json")
    fun getCurrentWeatherInfo(@Query("data.city") location: String): Call<weatherResponse>
}