package com.example.app_sekolah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.app_sekolah.databinding.ActivityDetailMapsSekolahBinding

class DetailMapsSekolahActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDetailMapsSekolahBinding
    private lateinit var tvNamaLokasiSekolah : TextView
    private lateinit var imgSekolah : ImageView
    private lateinit var tvDeskripsi : TextView
    private lateinit var btnSekolah : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMapsSekolahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvNamaLokasiSekolah = findViewById(R.id.tvNamaLokasiSekolah)
        imgSekolah = findViewById(R.id.imgSekolah)
        tvDeskripsi = findViewById(R.id.tvDeskripsi)
        btnSekolah = findViewById(R.id.btnSekolah)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //mengambil data dari intent
        val NamaLokasiSekolah = intent.getStringExtra("NamaLokasiSekolah")
        val gambarSekolah = intent.getIntExtra("gambarSekolah",0)
        val Deskripsi = intent.getStringExtra("Deskripsi")
        val latSekolah = intent.getDoubleExtra("latSekolah",0.0)
        val longSekolah = intent.getDoubleExtra("longSekolah",0.0)


        tvNamaLokasiSekolah.text = NamaLokasiSekolah
        imgSekolah.setImageResource(gambarSekolah)
        tvDeskripsi.text = Deskripsi

        btnSekolah.setOnClickListener{
            val intentMapSekolah = Intent(this,MapsWisataActivity::class.java)
            //kirim lat dan long
            intentMapSekolah.putExtra("latSekolah",latSekolah)
            intentMapSekolah.putExtra("longSekolah",longSekolah)
            intentMapSekolah.putExtra("NamaLokasiSekolah",NamaLokasiSekolah)
            startActivity(intentMapSekolah)
        }

        // Add a marker in Sydney and move the camera
        val KoordinatSekolah = LatLng(-latSekolah, longSekolah)
        mMap.addMarker(MarkerOptions().position(KoordinatSekolah).title("NamaLokasiSekolah"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(KoordinatSekolah, ))
    }
}