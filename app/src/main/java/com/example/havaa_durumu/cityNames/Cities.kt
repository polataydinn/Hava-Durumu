package com.example.havadurumuv10.sehirisimleri

import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import CitiesResponse
import com.example.havaa_durumu.iml.OnSuccess

class Cities {
    var onSuccess:OnSuccess? = null
    var sehirData: TextView? = null
    var BASE_URL = "https://gist.githubusercontent.com/"

    fun setOnSuc(os:OnSuccess){
        this.onSuccess = os
    }

    fun getCitiesName() {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(ApiService::class.java)
            val call = service.guncelSehirIsimleriData()
            var res : ArrayList<CitiesResponse.Item> = ArrayList()


            call.enqueue(object : Callback<CitiesResponse> {
                override fun onResponse(call: Call<CitiesResponse>, response: Response<CitiesResponse>) {
                    var cities = response.body()
                    Log.d("CEVAP : ", cities.toString())
                    for(i in 0 until 81){
                       res.add(cities!!.get(i))

                    }
                    onSuccess?.execute(res)

                }
                override fun onFailure(call: Call<CitiesResponse>, t: Throwable) {
                        sehirData!!.text = t.message
                }
            })

        }

}


