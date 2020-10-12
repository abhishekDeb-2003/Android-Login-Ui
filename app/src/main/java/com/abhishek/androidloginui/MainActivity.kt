package com.abhishek.androidloginui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var usernameEdt: EditText
    private lateinit var passwordEdt: EditText
    private lateinit var loginBtn: Button
    private lateinit var signUpBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEdt = findViewById(R.id.username_edt)
        passwordEdt = findViewById(R.id.password_edt)

        loginBtn = findViewById(R.id.login_btn)
        signUpBtn = findViewById(R.id.signUp_btn)

        loginBtn.setOnClickListener{
            login()
        }

        signUpBtn.setOnClickListener{
            signUp()
        }

    }

    private fun signUp() {
        startActivity(Intent(applicationContext, SignUp::class.java))
    }

    private fun login() {
        val username: String = "raju@babubhaiyya.com"
        val password: String = "ye_raju_kaStyle_Hai@39"

        if(getUsernameFromEdt() == username && getPasswordFromEdt() == password){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUsernameFromEdt(): String{ return usernameEdt.text.trim().toString() }

    private fun getPasswordFromEdt(): String{ return passwordEdt.text.toString() }



}