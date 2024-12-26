package com.example.healthcarekt

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class Home_page : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    lateinit var gridview : GridView
    lateinit var doclist :List<GridViewModel>


        setContentView(R.layout.home_page)

        gridview = findViewById(R.id.gridviewdocs)
        doclist  = ArrayList<GridViewModel>()

        doclist = doclist + GridViewModel("Lab Test",R.drawable.sample)
        doclist = doclist + GridViewModel("Medicine",R.drawable.medicine)
        doclist = doclist + GridViewModel("Doctors",R.drawable.medicalteam)
        doclist = doclist + GridViewModel("Health tips",R.drawable.medical)
        doclist = doclist + GridViewModel("Order Details",R.drawable.test)
        doclist = doclist + GridViewModel("Exit",R.drawable.info)

        val adapter = AdapterGridView(doclist = doclist ,this@Home_page)
        gridview.adapter = adapter


        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, view,position, id ->

            var intentlab          = Intent(this@Home_page, Lab_tests::class.java)
            var intentmedicine     = Intent(this@Home_page, Medicine::class.java)
            var intentdoctor       = Intent(this@Home_page, Doctos::class.java)
            var intenthealthtips   = Intent(this@Home_page, Health_tips::class.java)
            var intentorderdetails = Intent(this@Home_page, Order_details::class.java)
            var intentexit         = Intent(this@Home_page, Login_Page::class.java)



            when(position){
                0 -> startActivity(intentlab)
                1 -> startActivity(intentmedicine)
                2 -> startActivity(intentdoctor)
                3 -> startActivity(intenthealthtips)
                4 -> startActivity(intentorderdetails)
                5 -> startActivity(intentexit)
            }
    }
}
}
