package com.example.havadurumuv10.sehirisimleri

import retrofit2.Call
import retrofit2.http.GET
import CitiesResponse

interface ApiService {

@GET("Oct4via/452115fa717637ec4966aa18adfceee3/raw/4754e5f9d09dade2e6c461d7e960e13ef38eaa88/cities_of_turkey.json")
fun guncelSehirIsimleriData(): Call<CitiesResponse>
}