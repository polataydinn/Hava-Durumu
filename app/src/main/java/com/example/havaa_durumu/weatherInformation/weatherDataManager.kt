package com.example.havadurumuv10.havadurumubilgisi

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
                Const.CURRENT_WEATHER = response.body()!!.result[0].degree
                Const.DAYS_OF_WEEK1 = response.body()!!.result[1].day
                Const.DAYS_OF_WEEK2 = response.body()!!.result[2].day
                Const.DAYS_OF_WEEK3 = response.body()!!.result[3].day
                Const.DAYS_OF_WEEK4 = response.body()!!.result[4].day
                Const.DAYS_OF_WEEK5 = response.body()!!.result[5].day
                Const.DAYS_OF_WEEK6 = response.body()!!.result[6].day

                if (response.code() == 200) {
                    val _weatherResponse = response.body()!!

                    if(Const.SWITCH_CASE == 0){
                     val stringBuilder =
                         "Bugün" + "\n" +
                                 _weatherResponse?.city +
                                 "\n" +
                                 "Sıcaklık: " +
                                   _weatherResponse?.result[0].degree +
                                   "\n"
                       wh?.execute(stringBuilder.toString())

                    }
                   else if(Const.SWITCH_CASE == 1){
                        val stringBuilder1 =
                            _weatherResponse.result[1].day + "\n" +
                                    _weatherResponse?.city +
                                    "\n" +
                                    "Sıcaklık: " +
                                    _weatherResponse?.result[1].degree +
                                    "\n"
                        wh?.execute(stringBuilder1.toString())

                    }
                   else if(Const.SWITCH_CASE == 2){
                        val stringBuilder2 =
                            _weatherResponse.result[2].day + "\n" +
                                    _weatherResponse?.city +
                                    "\n" +
                                    "Sıcaklık: " +
                                    _weatherResponse?.result[2].degree +
                                    "\n"
                        wh?.execute(stringBuilder2.toString())

                    }
                   else if(Const.SWITCH_CASE == 3){
                        val stringBuilder3 =
                            _weatherResponse.result[3].day + "\n" +
                                    _weatherResponse?.city +
                                    "\n" +
                                    "Sıcaklık: " +
                                    _weatherResponse?.result[3].degree +
                                    "\n"
                        wh?.execute(stringBuilder3.toString())

                    }
                   else if(Const.SWITCH_CASE == 4){
                        val stringBuilder4 =
                            _weatherResponse.result[4].day + "\n" +
                                    _weatherResponse?.city +
                                    "\n" +
                                    "Sıcaklık: " +
                                    _weatherResponse?.result[4].degree +
                                    "\n"
                        wh?.execute(stringBuilder4.toString())

                    }
                    else if(Const.SWITCH_CASE == 5){
                        val stringBuilder5 =
                            _weatherResponse.result[5].day + "\n" +
                                    _weatherResponse?.city +
                                    "\n" +
                                    "Sıcaklık: " +
                                    _weatherResponse?.result[5].degree +
                                    "\n"
                        wh?.execute(stringBuilder5.toString())

                    }
                   else if(Const.SWITCH_CASE == 6){
                        val stringBuilder6 =
                            _weatherResponse.result[6].day + "\n" +
                                    _weatherResponse?.city +
                                    "\n" +
                                    "Sıcaklık: " +
                                    _weatherResponse?.result[6].degree +
                                    "\n"
                        wh?.execute(stringBuilder6.toString())

                    }
                }
            }

            override fun onFailure(call: Call<weatherResponse>, t: Throwable) {

            }
        })

    }
}