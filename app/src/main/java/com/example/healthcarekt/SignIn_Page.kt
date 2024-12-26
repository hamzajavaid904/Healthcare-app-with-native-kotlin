package com.example.healthcarekt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

lateinit var Btnlogin : Button
lateinit var Btnsignup : Button

class SignIn_Page : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_page)

        Btnlogin = findViewById(R.id.loginbtn)
        Btnsignup = findViewById(R.id.signupbtn)


        Btnlogin.setOnClickListener{
            var intent = Intent(this@SignIn_Page,Login_Page::class.java)
            startActivity(intent)
        }

        Btnsignup.setOnClickListener{
            var intent = Intent(this@SignIn_Page,Signup_page::class.java)
            startActivity(intent)
        }

    }
}