package com.example.healthcarekt

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.ComponentActivity

class Lab_tests : ComponentActivity() {

    var packages : Array<Array<String>> = arrayOf(
        arrayOf("Package 1 : Full body checkup","1000"),
        arrayOf("Package 2 : Blood Glucose Fasting","300"),
        arrayOf("Package 3 : COVID-19 IgG","900"),
        arrayOf("Package 4 : Thyriod check","500"),
        arrayOf("Package 5 : Immunity check","700")
    )

    var package_details : Array<String> =
        arrayOf(  "1) Blood Glucose Fasting \n\n" + "2) Complete Hemogram \n\n" + "3) HbA1c \n\n" + "4) Iron Studies \n\n" + "5) Kidney function test \n\n" + "6) LDH Lactate Dehydrogenase, Serum\n\n" + "7) Lipid Profile \n\n" + "8) liver function test" ,
        "1) Blood Glucose Fasting ",
        "1) COVID-19 Antibody - IgG",
        "1) Thyriod Profile-Total (T3, T4 & TSH Ultra-sensitive)",
        "1) Complete Hemogram \n\n" + "2) CRP( C Reactive Protien) Quantitative , serum \n\n" + "3) Iron studies \n\n" + "4) Kidney Function Test \n\n" + "5) Vitamin - D Total-25 Hydroxy \n\n" + "6) Liver Funtion test \n\n" + "7) Lipid Profile"
    )

    lateinit var listview : ListView
    lateinit var btnback  : Button
    lateinit var btncart  : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab_tests)

        listview = findViewById(R.id.listview_lab)
        btncart  = findViewById(R.id.btncart)
        btnback  = findViewById(R.id.btnback)

        btnback.setOnClickListener {
            var intent = Intent(this@Lab_tests,Home_page::class.java)
            startActivity(intent)
        }

       var list = ArrayList<HashMap<String,String>>()
        for ( i in packages.indices){

            val hashMap = HashMap<String, String>()
            hashMap.put("line1",packages[i][0])
            hashMap.put("line2",packages[i][1])
            list.add(hashMap)
        }
        val SimpleAdapter = SimpleAdapter(this,list,R.layout.multilines, arrayOf("line1","line2"),
          intArrayOf(R.id.line_a,R.id.line_e)
        )
        listview.adapter = SimpleAdapter


        listview.setOnItemClickListener { parent, view, position, id ->

            var it = Intent(this@Lab_tests,Lab_Test_Details :: class.java)

            it.putExtra("text1",packages[position][0])
            it.putExtra("text2",package_details[position])
            it.putExtra("text3",packages[position][1])
            startActivity(it)

        }

    }
}