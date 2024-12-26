package com.example.healthcarekt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class Login_Page : ComponentActivity() {

    var signup : TextView ?= null
    lateinit var  edemail : EditText
    lateinit var edpassword : EditText
    var textviewfg : TextView ?= null
    var btnlogin : Button ?=null
    lateinit var imgback : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        signup = findViewById(R.id.signup)
        edemail = findViewById(R.id.edit_text_Email)
        edpassword = findViewById(R.id.edit_text_Password)
        textviewfg = findViewById(R.id.text_fg)
        btnlogin = findViewById(R.id.button_Login)
        imgback  = findViewById(R.id.imgback)


        btnlogin !!.setOnClickListener {

            val Email: String = edemail.getText().toString()
            val Password: String = edpassword.getText().toString()


            if (Email.length == 0 || Password.length == 0) {
                Toast.makeText(this@Login_Page, "Please fill all the boxes", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this@Login_Page,"login sucessfully",Toast.LENGTH_SHORT).show()
                var intent = Intent(this@Login_Page, Home2::class.java)
                startActivity(intent)
            }

        }


        signup !! .setOnClickListener {
            var intent =Intent(this@Login_Page,Signup_page::class.java)
            startActivity(intent)
        }

        imgback.setOnClickListener {
            var intent =Intent(this@Login_Page,SignIn_Page::class.java)
            startActivity(intent)
        }



    }
}