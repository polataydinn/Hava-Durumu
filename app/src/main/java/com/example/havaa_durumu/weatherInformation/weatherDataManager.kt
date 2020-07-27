package com.example.havadurumuv10.havadurumubilgisi

import android.util.Log
import com.example.havaa_durumu.Const
import com.example.havaa_durumu.iml.WeatherListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class weatherDataManager {


    var newReturnWeather: String? = null
    var wh: WeatherListener? = null

    fun setWeatherListener(weatherListener: WeatherListener) {
        this.wh = weatherListener
    }

    fun getData(newLocation: String) {

        var location = newLocation
        val retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(weatherAPIService::class.java)
        val call = service.getCurrentWeatherInfo(location)

        call.enqueue(object : Callback<weatherResponse> {
            override fun onResponse(
                call: Call<weatherResponse>,
                response: Response<weatherResponse>
            ) {
                newReturnWeather = response.body()!!.result[0].icon
                Const.CURRENT_STATUS = response.body()!!.result[0].status
                Const.TOMORROW_STATUS = response.body()!!.result[1].status
                Log.d("CEVAP ", "status : "+ Const.CURRENT_STATUS)

                if (response.code() == 200) {
                    val _weatherResponse = response.body()!!
                    Log.d("Cevap : ", _weatherResponse.toString())

                    val stringBuilder =
                        "    Bugün" + "\n" +
                                "Şehir: " +
                                _weatherResponse?.city +
                                "\n" +
                                "Sıcaklık: " +
                                _weatherResponse?.result[0].degree +
                                "\n" +
                                "Sıcaklık(Min): " +
                                _weatherResponse?.result[0].min +
                                "\n" +
                                "Sıcaklık(Max): " +
                                _weatherResponse?.result[0].max +
                                "\n \n \n \n" + "    Yarın" +
                                "\n" +
                                "Şehir: " +
                                _weatherResponse?.city +
                                "\n" +
                                "Sıcaklık: " +
                                _weatherResponse?.result[1].degree +
                                "\n" +
                                "Sıcaklık(Min): " +
                                _weatherResponse?.result[1].min +
                                "\n" +
                                "Sıcaklık(Max): " +
                                _weatherResponse?.result[1].max +
                                "\n"


                    wh?.execute(stringBuilder.toString())

                }
            }

            override fun onFailure(call: Call<weatherResponse>, t: Throwable) {

            }
        })

    }
}