package com.example.havadurumuv10.havadurumubilgisi

import com.example.havadurumuv10.havadurumubilgisi.havaDurumuResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface havaDurumuServisi {
    @GET("weather/getWeather?data.lang=tr")
    @Headers("authorization: apikey 6RkfJoBGmqnhdpQkGmiafZ:6VwuH2HhU47o0Z3xUpkFBc","content-type: application/json")
    fun guncelHavaDurumuData(@Query("data.city") konum: String): Call<havaDurumuResponse>
}