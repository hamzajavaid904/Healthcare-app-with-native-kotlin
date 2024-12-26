package com.example.healthcarekt

import android.app.AppComponentFactory
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.security.PublicKey

class Signup_page : ComponentActivity(){

     lateinit var edusername : EditText
     lateinit var edemail : EditText
     lateinit var edpassword : EditText
     lateinit var textlogin : TextView
     lateinit var btnsignup : Button
     lateinit var imgback : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)

        edusername     = findViewById(R.id.edit_text_Username)
        edemail        = findViewById(R.id.edit_text_Email)
        edpassword     = findViewById(R.id.edit_text_Password)
        textlogin      = findViewById(R.id.text_loginhere)
        btnsignup      = findViewById(R.id.button_signup)
        imgback        = findViewById(R.id.imgback)


        btnsignup!!.setOnClickListener {

            val Username    : String = edusername.text.toString()
            val Email       : String = edemail.text.toString()
            val Password    : String = edpassword.text.toString()

            if (Username.isEmpty() || Email.isEmpty() || Password.isEmpty()){

                Toast.makeText(this@Signup_page,"please fill all the boxes",Toast.LENGTH_SHORT).show()
            }

                else{

                var intent = Intent(this@Signup_page,Home_page::class.java)
                startActivity(intent)
                }
            }



        textlogin!!.setOnClickListener {
            var intent = Intent(this@Signup_page,Login_Page::class.java)
            startActivity(intent)
        }
        imgback.setOnClickListener {
            var intent = Intent(this@Signup_page,Login_Page::class.java)
            startActivity(intent)
        }
    }
    }