package com.example.havaa_durumu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity() {
    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        mapFragment = supportFragmentManager.findFragmentById(R.id.mapID) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it

            val locationLatLong = LatLng(Const.LATITUTE.toDouble(), Const.LONGITUTE.toDouble())
            googleMap.addMarker(MarkerOptions().position(locationLatLong).title("Sıcaklık :"+Const.CURRENT_WEATHER))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(locationLatLong,10f))
        })
    }
}