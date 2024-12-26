package com.example.healthcarekt

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


lateinit var imgback : ImageView
lateinit var recyclerviewpp: RecyclerView
lateinit var recyclerviewpos: RecyclerView
lateinit var camera : Button
//lateinit var imgshow1 : ImageView

class Pharmacy : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pharmacy)

        imgback = findViewById(R.id.imgbackp)
        recyclerviewpp = findViewById(R.id.recyclerviewpp)
        recyclerviewpos = findViewById(R.id.recyclerviewpos)
        camera = findViewById(R.id.take_an_image)
        //imgshow1 = findViewById(R.id.imgshow)




        recyclerviewpp.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var medicinedata = ArrayList<ItemViewModelpharm>()
        for (i in 1..5) {
            medicinedata.add(ItemViewModelpharm(R.drawable.contractrqe1, "panadol", "12pcs", "Rs.20"))
        }
        var medadapter = AdapterPharma(medicinedata)
        recyclerviewpp.adapter = medadapter

        medadapter.setOnClickListener(object : AdapterPharma.OnClickListener{
            override fun onClick(position: Int) {
                var intent = Intent(this@Pharmacy,Pharmacy_Details::class.java)
                intent.putExtra("imgmed",medicinedata[position].imagemed)
                startActivity(intent)
            }
        })

        recyclerviewpos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var medicinedatapos = ArrayList<ItemViewModelPharmsale>()
        for (i in 1..5) {
            medicinedatapos.add(ItemViewModelPharmsale(R.drawable.contractrqe1, "panadol", "12pcs", "Rs.20","RS.30"))

        }
        var medadapterpos = AdapterPOS(medicinedatapos)
        recyclerviewpos.adapter = medadapterpos


        imgback.setOnClickListener {
            var intent = Intent(this@Pharmacy, Home2::class.java)
            startActivity(intent)
        }
        camera.setOnClickListener({
            val cameraintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraintent, pic_id)
        })
    }

    companion object {
        // Define the pic id
         val pic_id = 1
    }
    // this method is used to display the image in our app
  /*override  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pic_id) {
            val photo = data!!.extras!!["data"] as Bitmap?
            imgshow1.setImageBitmap(photo)
        }

    }*/
}