package com.example.havaa_durumu

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.havadurumuv10.sehirisimleri.Cities


class CityAdaptor(cityList: ArrayList<CitiesResponse.Item>) :
    RecyclerView.Adapter<CityAdaptor.MyCityHolder>() {

    var mCityList = cityList



    override fun onBindViewHolder(holder: MyCityHolder, position: Int) {
        holder.changeText(mCityList.get(position).name)
        holder.setLatLon(mCityList.get(position).latitude.toDouble(),mCityList.get(position).longitude.toDouble())
    }

    class MyCityHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tView: TextView = view.findViewById(R.id.text)
        val rLay: RelativeLayout = view.findViewById(R.id.relative)
        var rWeather: String? = null
        var mContext : Context? = null
        var mLat: Double? = null
        var mLon: Double? = null

        fun setContext(c:Context){
            this.mContext = c
        }

        init {
            rLay.setOnClickListener(View.OnClickListener {

                Log.d("CEVAP ", "selam ben " + tView.text.toString())

                Const.CURRENT_CITY = tView.text.toString()
                Const.SWITCH_CASE = 0
                Const.LATITUTE = this.mLat!!
                Const.LONGITUTE= this.mLon!!

                val intent = Intent(mContext,show_weather::class.java)
                startActivity(mContext!!,intent,null)

            })
        }



        fun changeText(text: String) {
            tView.setText(text)
        }

        fun setLatLon(lat:Double,lon:Double){
            this.mLat = lat
            this.mLon = lon
        }

        fun changeAcitivity(): Boolean {
            return true
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCityHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.city, parent, false)
        var cityHolder = MyCityHolder(view)
        cityHolder.setContext(parent.context)
        return cityHolder
    }

    override fun getItemCount(): Int {
        return mCityList.size
    }
}