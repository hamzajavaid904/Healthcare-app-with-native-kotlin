package com.example.healthcarekt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
lateinit var button: Button
class Pharmacy_Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pharmdetails)

        button = findViewById(R.id.buybtn)

        button.setOnClickListener({
            var intent = Intent(this@Pharmacy_Details,My_cart::class.java)
            startActivity(intent)
        })

    }
}