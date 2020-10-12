package com.abhishek.androidloginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {

    private lateinit var usernameEdt: EditText
    private lateinit var passwordEdt: EditText
    private lateinit var confirmPasswordEdt: EditText
    private lateinit var signUpBtn: Button
    private var passwordText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        usernameEdt = findViewById(R.id.username_edt)
        passwordEdt = findViewById(R.id.password_edt)
        confirmPasswordEdt = findViewById(R.id.confirm_password_edt)

        signUpBtn = findViewById(R.id.login_btn)

        signUpBtn.setOnClickListener{
            signUp()
        }

    }

    private fun signUp() {
        val usernameText = usernameEdt.text.trim().toString()
        if(validatePassword()){
            signUpBtn.isEnabled = false
            Toast.makeText(this, "Username: $usernameText \n Password: $passwordText",
                Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }else{
            Toast.makeText(this, "Passwords does not match", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validatePassword(): Boolean {
        passwordText = passwordEdt.text.toString()
        val confirmPasswordText: String = confirmPasswordEdt.text.toString()

        return passwordText == confirmPasswordText
    }
}