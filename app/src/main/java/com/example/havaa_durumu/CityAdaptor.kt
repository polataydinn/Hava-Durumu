package com.example.havaa_durumu

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.havadurumuv10.havadurumubilgisi.DataManager


class CityAdaptor(cityList: ArrayList<CitiesResponse.Item>) :
    RecyclerView.Adapter<CityAdaptor.MyCityHolder>() {

    var mCityList = cityList


    override fun onBindViewHolder(holder: MyCityHolder, position: Int) {
        holder.changeText(mCityList.get(position).name)
    }

    class MyCityHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tView: TextView = view.findViewById(R.id.text)
        val rLay: RelativeLayout = view.findViewById(R.id.relative)
        var rWeather: String? = null

        init {
            rLay.setOnClickListener(View.OnClickListener {
                DataManager.dataAl(tView.text.toString())
                Log.d("CEVAP ", "selam ben " + tView.text.toString())
                Const.CURRENT_CITY = tView.text.toString()

              //  val intent = Intent(this,show_weather::class.java)
                //startActivity(intent)

            })
        }



        fun changeText(text: String) {
            tView.setText(text)
        }

        fun changeAcitivity(): Boolean {
            return true
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCityHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.city, parent, false)
        return MyCityHolder(view)
    }

    override fun getItemCount(): Int {
        return mCityList.size
    }
}