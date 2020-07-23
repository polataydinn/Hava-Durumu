package com.example.havadurumuv10.havadurumubilgisi

import android.util.Log
import android.widget.TextView
import com.example.havaa_durumu.Const
import com.example.havaa_durumu.iml.OnSuccess
import com.example.havaa_durumu.iml.WeatherListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DataManager {


    var newReturnWeather: String? = null
    var wh: WeatherListener? = null

    fun setWeatherListener(weatherListener: WeatherListener){
        this.wh = weatherListener
    }

    fun dataAl(newLocation: String) {

        var konum = newLocation
        val retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(havaDurumuServisi::class.java)
        val call = service.guncelHavaDurumuData(konum)

        Log.i("linkimiz", call.toString())

        call.enqueue(object : Callback<havaDurumuResponse> {
            override fun onResponse(
                call: Call<havaDurumuResponse>,
                response: Response<havaDurumuResponse>
            ) {
                newReturnWeather = response.body()!!.toString()
                if (response.code() == 200) {
                    val _havaDurumuResponse = response.body()!!
                    Log.d("Cevap : ", _havaDurumuResponse.toString())

                    val stringBuilder =
                        "    Bugün" + "\n" +
                                "Şehir: " +
                                _havaDurumuResponse?.city +
                                "\n" +
                                "Sıcaklık: " +
                                _havaDurumuResponse?.result[0].degree +
                                "\n" +
                                "Sıcaklık(Min): " +
                                _havaDurumuResponse?.result[0].min +
                                "\n" +
                                "Sıcaklık(Max): " +
                                _havaDurumuResponse?.result[0].max +
                                "\n \n \n \n"  +        "    Yarın" +
                                "\n" +
                                "Şehir: " +
                                _havaDurumuResponse?.city +
                                "\n" +
                                "Sıcaklık: " +
                                _havaDurumuResponse?.result[1].degree +
                                "\n" +
                                "Sıcaklık(Min): " +
                                _havaDurumuResponse?.result[1].min +
                                "\n" +
                                "Sıcaklık(Max): " +
                                _havaDurumuResponse?.result[1].max +
                                "\n"

                    wh?.execute(stringBuilder.toString())

                }
            }

            override fun onFailure(call: Call<havaDurumuResponse>, t: Throwable) {

            }
        })

    }

}