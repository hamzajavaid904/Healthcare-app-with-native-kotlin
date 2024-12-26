package com.example.healthcarekt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class Onboarding :  ComponentActivity() {

    var lst = listOf<String>()
    var imlst = listOf<Int>()
    lateinit var viewPager2: ViewPager2
    lateinit var imageView: ImageView
    lateinit var TextView:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)

        imageView = findViewById(R.id.imgnext)
        TextView = findViewById(R.id.SKip)

        imageView.setOnClickListener{
            var intent = Intent(this@Onboarding,SignIn_Page::class.java)
            startActivity(intent)
        }
          TextView.setOnClickListener{
            var intent = Intent(this@Onboarding,SignIn_Page::class.java)
            startActivity(intent)
        }




        viewPager2 = findViewById(R.id.viewPager)
        lst= listOf("Find a lot of specialist doctors in one place","Get advice only from a doctor you believe in.")
        imlst= listOf(R.drawable.doctor1,R.drawable.doctor2)
        val adapter = AdapterViewPager(lst,imlst)
        viewPager2.adapter= adapter

        window.statusBarColor = ContextCompat.getColor(this, R.color.teal_200)

    }
}