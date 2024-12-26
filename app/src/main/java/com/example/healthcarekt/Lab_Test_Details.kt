package com.example.healthcarekt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class Lab_Test_Details :  ComponentActivity(){

    lateinit var editText     : EditText
    lateinit var txtname      : TextView
    lateinit var txtcost      : TextView
    lateinit var btnaddtocart : Button
    lateinit var btnback      : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab_test_details)

        txtname      = findViewById(R.id.txtname)
        txtcost      = findViewById(R.id.txtcost)
        editText     = findViewById(R.id.edit_text_labtdetails)
        btnback      = findViewById(R.id.buttonbackltd)
        btnaddtocart = findViewById(R.id.btn_add_cart)



        val intent = intent
        txtname. setText(intent.getStringExtra("text1"))
        editText.setText(intent.getStringExtra("text2"))
        txtcost. setText(intent.getStringExtra("text3"))

        btnback.setOnClickListener {
            var intent = Intent(this@Lab_Test_Details,Lab_tests::class.java)
            startActivity(intent)
        }


    }

}