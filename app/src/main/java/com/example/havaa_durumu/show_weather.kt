package com.example.havaa_durumu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.havaa_durumu.iml.WeatherListener
import com.example.havadurumuv10.havadurumubilgisi.weatherDataManager
import kotlinx.android.synthetic.main.activity_show_weather.*
import java.util.concurrent.TimeUnit

class show_weather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_weather)
        var dm = weatherDataManager()


       dm.setWeatherListener(object : WeatherListener {
            override fun execute(data: String) {

                findViewById<TextView>(R.id.textView).setText(data)
                Glide.with(this@show_weather)
                    .load(Const.STATUS_MAP.get(Const.CURRENT_STATUS))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(wimg1)

                Glide
                    .with(this@show_weather)
                    .load(Const.STATUS_MAP.get(Const.TOMORROW_STATUS))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(wimg2)

              }

           }
        )



        dm.getData(Const.CURRENT_CITY)
    }

}