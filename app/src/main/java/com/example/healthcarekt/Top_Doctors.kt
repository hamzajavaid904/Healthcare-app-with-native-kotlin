package com.example.healthcarekt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var Docrecycler : RecyclerView
class Top_Doctors : ComponentActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top_doctors)

        Docrecycler = findViewById(R.id.docrecycler)


        Docrecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        var doc = ArrayList<ItemViewModel2>()
        for (i in 1 .. 9)
        {
            doc.add(ItemViewModel2(R.drawable.doctor1,"hushdjdouhwudilywdvvwv","3june2023","4.7","800meter"))
        }
        var adapterdoc = AdapterTD(doc)
        Docrecycler.adapter = adapterdoc


        adapterdoc.setOnClickListener(object : AdapterTD.OnClickListener{
            override fun onClick(position : Int){
                var intent = Intent(this@Top_Doctors,Doctors_Details::class.java)
                intent.putExtra("img",doc[position].image2)
                intent.putExtra("docname",doc[position].Docname)
                intent.putExtra("specaility",doc[position].specaility)
                intent.putExtra("rating",doc[position].rating)
                intent.putExtra("location",doc[position].location)
                startActivity(intent)


            }
        })
    }
}