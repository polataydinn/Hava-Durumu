package com.example.havaa_durumu


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.havaa_durumu.iml.OnSuccess
import com.example.havadurumuv10.sehirisimleri.Cities

class MainActivity : AppCompatActivity() {

    lateinit var rView: RecyclerView
    var mItemList: ArrayList<CitiesResponse.Item> = ArrayList()

    var buttonTagChanger: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Const.initClass()
        rView = findViewById(R.id.rView)
        callCities()

        Toast.makeText(applicationContext, "App started!", Toast.LENGTH_SHORT).show()

        rView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }


    private fun callCities() {


        var cityNames = Cities()

        cityNames.setOnSuc(object : OnSuccess {
            override fun execute(items: ArrayList<CitiesResponse.Item>) {
                rView.adapter = CityAdaptor(items)
            }
        })

        cityNames.getCitiesName()






    }


    private fun exampleItemList(): ArrayList<CitiesResponse.Item> {
        var mItemList: ArrayList<CitiesResponse.Item> = ArrayList()
        var item: CitiesResponse.Item =
            CitiesResponse.Item(1, "37.00", "35.3213", "Adana", 2183167, "Akdeniz")

        mItemList.add(item)
        mItemList.add(item)
        return mItemList
    }
}


