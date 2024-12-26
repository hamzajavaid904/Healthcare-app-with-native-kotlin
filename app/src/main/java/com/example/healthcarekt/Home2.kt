package com.example.healthcarekt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var recyclerView: RecyclerView
lateinit var topdoc : LinearLayout
lateinit var ambulance : LinearLayout
lateinit var pharmacy: LinearLayout

class Home2 : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = resources.getColor(R.color.white)
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.grey)
        }
        setContentView(R.layout.home2)

        recyclerView = findViewById(R.id.recyclerview)
        topdoc = findViewById(R.id.topdoc)
        ambulance = findViewById(R.id.ambulance)
        pharmacy = findViewById(R.id.pharm)

        pharmacy.setOnClickListener {
            var intent = Intent(this@Home2,Pharmacy::class.java)
            startActivity(intent)
        }

        ambulance.setOnClickListener{
            var intent = Intent(this@Home2,Ambulance::class.java)
            startActivity(intent)
        }


        topdoc.setOnClickListener {
            var intent = Intent(this@Home2,Top_Doctors::class.java)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        var catdata = ArrayList<ItemViewModel>()
        for (i in 1 .. 5)
        {
            catdata.add(ItemViewModel(R.drawable.doctor1,"hushdjdouhwudilywdvvwv","3june2023","5minread"))
        }
        var adaptercat = Adapter(catdata)
        recyclerView.adapter = adaptercat
       // window.navigationBarColor = ContextCompat.getColor(this, R.color.white)
    }
}