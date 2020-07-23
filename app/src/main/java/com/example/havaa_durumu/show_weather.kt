package com.example.havaa_durumu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.havaa_durumu.iml.WeatherListener
import com.example.havadurumuv10.havadurumubilgisi.DataManager

class show_weather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_weather)
        var dm = DataManager()

        dm.setWeatherListener(object : WeatherListener {
            override fun execute(data: String) {
                findViewById<TextView>(R.id.textView).setText(data)
            }
        })

        dm.dataAl(Const.CURRENT_CITY)
    }
}