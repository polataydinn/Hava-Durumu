package com.example.havaa_durumu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.havaa_durumu.iml.WeatherListener
import com.example.havadurumuv10.havadurumubilgisi.weatherDataManager
import kotlinx.android.synthetic.main.activity_show_weather.*
import java.util.concurrent.TimeUnit
import kotlin.math.log

class show_weather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_weather)
        var dm = weatherDataManager()
        var button: Button? = null
        var button1: Button? = null
        var button2: Button? = null
        var button3: Button? = null
        var button4: Button? = null
        var button5: Button? = null
        var button6: Button? = null
        var mapButton: Button? = null
        button = findViewById(R.id.dButton1)
        button1 = findViewById(R.id.dButton2)
        button2 = findViewById(R.id.dButton3)
        button3 = findViewById(R.id.dButton4)
        button4 = findViewById(R.id.dButton5)
        button5 = findViewById(R.id.dButton6)
        button6 = findViewById(R.id.dButton7)
        mapButton = findViewById(R.id.mapButton)

        if(Const.SWITCH_CASE == 0) {getDataStart()}
        button.setText("Bugün")
        button.setOnClickListener {
            Const.SWITCH_CASE = 0
            getDataClone()
        }


        button1.setOnClickListener {
            Const.SWITCH_CASE = 1
            getDataClone()
        }

        button2.setOnClickListener {
            Const.SWITCH_CASE = 2
            getDataClone()
        }

        button3.setOnClickListener {
            Const.SWITCH_CASE = 3
            getDataClone()
        }

        button4.setOnClickListener {
            Const.SWITCH_CASE = 4
            getDataClone()
        }

        button5.setOnClickListener {
            Const.SWITCH_CASE = 5
            getDataClone()
        }

        button6.setOnClickListener {
            Const.SWITCH_CASE = 6
            getDataClone()
        }

        mapButton.setOnClickListener{
            val intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }


    }
fun getDataStart(){
    var dm  = weatherDataManager()
    dm.setWeatherListener(object : WeatherListener {

        override fun execute(data: String) {

            findViewById<TextView>(R.id.textView).setText(data)

            Glide.with(this@show_weather)
                .load(Const.STATUS_MAP.get(Const.CURRENT_STATUS))
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(wimg1)
                dButton2.setText(Const.DAYS_OF_WEEK1)
                dButton3.setText(Const.DAYS_OF_WEEK2)
                dButton4.setText(Const.DAYS_OF_WEEK3)
                dButton5.setText(Const.DAYS_OF_WEEK4)
                dButton6.setText(Const.DAYS_OF_WEEK5)
                dButton7.setText(Const.DAYS_OF_WEEK6)
        }
    })

    dm.getData(Const.CURRENT_CITY)
}
    fun getDataClone(){
        var dm  = weatherDataManager()
        dm.setWeatherListener(object : WeatherListener {

            override fun execute(data: String) {

                findViewById<TextView>(R.id.textView).setText(data)

                Glide.with(this@show_weather)
                    .load(Const.STATUS_MAP.get(Const.CURRENT_STATUS))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(wimg1)

            }
        })

        dm.getData(Const.CURRENT_CITY)
    }


}