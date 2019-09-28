package com.fiapq.digiteendereco

import android.content.Intent
import android.location.Geocoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPesquisa.setOnClickListener {

            val geocoder = Geocoder(this, Locale.getDefault())

            val enderecos = geocoder.getFromLocationName(etEndereco.text.toString(), 1)

            val latitudeLongitude = "${enderecos[0].latitude},${enderecos[0].longitude}"
            val zoom = 15
            val geo = "geo:$latitudeLongitude?z=$zoom"

            val geoUri = Uri.parse(geo)
            val intent = Intent(Intent.ACTION_VIEW,geoUri)

            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }


    }


}
