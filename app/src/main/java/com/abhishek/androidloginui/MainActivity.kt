package com.abhishek.androidloginui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    private lateinit var usernameEdt: TextInputEditText

    private lateinit var passwordEdtLayout: TextInputLayout
    private lateinit var passwordEdt: TextInputEditText

    private lateinit var loginBtn: Button
    private lateinit var signUpBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEdt = findViewById(R.id.username_edt)

        passwordEdt = findViewById(R.id.password_edt)
        passwordEdtLayout = findViewById(R.id.password_edt_layout)

        passwordEdt.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                passwordEdtLayout.error = null
            }

            override fun afterTextChanged(p0: Editable?) {
                passwordEdt.error = null
            }


        })

        loginBtn = findViewById(R.id.login_btn)
        signUpBtn = findViewById(R.id.signUp_btn)

        loginBtn.setOnClickListener { login() }

        signUpBtn.setOnClickListener { signUp() }

    }

    private fun signUp() {
        startActivity(Intent(applicationContext, SignUp::class.java))
    }

    private fun login() {
        val username: String = "raju@babubhaiyya.com"
        val password: String = "ye_raju_kaStyle_Hai@39"

        if (getUsernameFromEdt() == username && getPasswordFromEdt() == password) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        } else if(getUsernameFromEdt() == username && getPasswordFromEdt() != password){
            passwordEdtLayout.error = "Invalid password!"
        }else{
            Toast.makeText(this,
                "Login Unsuccessful. Invalid username!",
                Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun getUsernameFromEdt(): String {
        return usernameEdt.text!!.trim().toString()
    }

    private fun getPasswordFromEdt(): String {
        return passwordEdt.text.toString()
    }


}