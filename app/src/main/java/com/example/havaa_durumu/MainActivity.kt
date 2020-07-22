package com.example.havaa_durumu


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.havadurumuv10.sehirisimleri.Cities

class MainActivity : AppCompatActivity() {

    lateinit var rView: RecyclerView
    var mItemList: ArrayList<CitiesResponse.Item> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rView = findViewById(R.id.rView)
        callCities()

        Toast.makeText(applicationContext, "App started!", Toast.LENGTH_SHORT).show()

        rView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }


    private fun callCities() {


            var t1: Thread = Thread(Runnable {
            var cityNames = Cities()
            var res = cityNames.getCitiesName()
            Log.d("CEVAP 2", res.toString())
            mItemList = res
            runOnUiThread(Runnable {
                rView.adapter = CityAdaptor(mItemList)


            })
           //
        })

        t1.start()

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


