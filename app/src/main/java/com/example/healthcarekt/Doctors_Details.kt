package com.example.healthcarekt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var docimgdd : ImageView
lateinit var docnamedd : TextView
lateinit var docspecailitydd : TextView
lateinit var docratingdd : TextView
lateinit var doclocationdd : TextView
lateinit var bundle: Bundle
lateinit var recyclerdate : RecyclerView
lateinit var gridview : GridView
lateinit var timelist :List<GridViewmodel1>
var position = -1;
var posi = 0


class Doctors_Details : ComponentActivity() {
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doctor_details)

        docimgdd = findViewById(R.id.docimageDD)
        docnamedd = findViewById(R.id.docnameDD)
        docspecailitydd = findViewById(R.id.specailityDD)
        docratingdd = findViewById(R.id.ratingDD)
        doclocationdd = findViewById(R.id.locationDD)
        recyclerdate = findViewById(R.id.recyclerviewdate)
        gridview = findViewById(R.id.gridviewtime)
        timelist = ArrayList<GridViewmodel1>()


        timelist = timelist + GridViewmodel1("09:00 am")
        timelist = timelist + GridViewmodel1("10:00 am")
        timelist = timelist + GridViewmodel1("11:00 am")
        timelist = timelist + GridViewmodel1("12:00 am")
        timelist = timelist + GridViewmodel1("01:00 am")
        timelist = timelist + GridViewmodel1("02:00 am")
        timelist = timelist + GridViewmodel1("03:00 am")
        timelist = timelist + GridViewmodel1("04:00 am")
        timelist = timelist + GridViewmodel1("05:00 am")
        timelist = timelist + GridViewmodel1("06:00 am")
        timelist = timelist + GridViewmodel1("07:00 am")
        timelist = timelist + GridViewmodel1("08:00 am")



       val adapter = GridViewAdaptertime(Timelist = timelist, position, this@Doctors_Details)
       gridview.adapter = adapter






        recyclerdate.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        var date = ArrayList<ItemViewModel3>()
        for (i in 1 .. 9)
        {
            date.add(ItemViewModel3("Mon","12"))
        }
        var dateadapter = AdapterDate(date,position,this@Doctors_Details)
        recyclerdate.adapter = dateadapter



        bundle = intent.extras!!
        val docimg = bundle.getInt("img")
        val docname = bundle.getString("docname")
        val docspecaility = bundle.getString("specaility")
        val docrating = bundle.getString("rating")
        val doclocation = bundle.getString("location")


        docimgdd.setImageResource(docimg)
        docnamedd.text = docname
        docspecailitydd.text = docspecaility
        docratingdd.text = docrating
        doclocationdd.text = doclocation

    }

    fun clickAdapter(pos : Int){
        position = pos;
        recyclerdate.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        var date = ArrayList<ItemViewModel3>()
        for (i in 1 .. 9)
        {
            date.add(ItemViewModel3("Mon","12"))
        }
        var dateadapter = AdapterDate(date,position,this@Doctors_Details)
        recyclerdate.adapter = dateadapter
    }
}