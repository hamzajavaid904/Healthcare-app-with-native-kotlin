package com.example.healthcarekt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteFragment
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

class Ambulance :AppCompatActivity(), OnMapReadyCallback {


    var mygoogle : GoogleMap ?= null
    lateinit var autocompleteFragment: AutocompleteSupportFragment
    lateinit var btn : ImageButton
    lateinit var popupMenu: PopupMenu
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ambulance)

        btn = findViewById(R.id.btn1)
        popupMenu = PopupMenu(this,btn)
        popupMenu.menuInflater.inflate(R.menu.map_opot,popupMenu.menu)

        Places.initialize(applicationContext,getString(R.id.maps))
        autocompleteFragment = supportFragmentManager.findFragmentById(R.id.places_fragment) as AutocompleteSupportFragment

        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS,Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object :PlaceSelectionListener{
            override fun onError(p0: Status) {
                Toast.makeText(this@Ambulance,"some error accured",Toast.LENGTH_SHORT).show()
            }

            override fun onPlaceSelected(p0: Place) {
                var latLng = p0.latLng!!
                zoomonMap(latLng)
            }

        })
        popupMenu.setOnMenuItemClickListener{ menuItem->
            changeMap(menuItem.itemId)
            true
        }
        btn.setOnClickListener{
            popupMenu.show()
        }

        var mapFragment = supportFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    fun zoomonMap(latLng: LatLng){
        val newlatlngzoom =     CameraUpdateFactory.newLatLngZoom(latLng,20f)
        mygoogle?.animateCamera(newlatlngzoom)

    }

    private fun changeMap(itemId: Int) {
        when(itemId){
            R.id.normalmap ->mygoogle?.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.satellitemap ->mygoogle?.mapType = GoogleMap.MAP_TYPE_SATELLITE
            R.id.hybridmap ->mygoogle?.mapType = GoogleMap.MAP_TYPE_HYBRID
            R.id.terrainmap ->mygoogle?.mapType = GoogleMap.MAP_TYPE_TERRAIN
        }

    }

    override fun onMapReady(mygoogleMap: GoogleMap) {

        mygoogle = mygoogleMap

        mygoogle!!.setOnMapClickListener {
            mygoogleMap.clear()
            addmarker(it)
        }
    }

   private fun addmarker(position:LatLng){
       mygoogle?.addMarker(MarkerOptions().position(position).title("marker"))
   }
}