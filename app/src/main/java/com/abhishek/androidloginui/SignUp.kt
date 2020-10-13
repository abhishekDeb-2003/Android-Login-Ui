package com.abhishek.androidloginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {

    private lateinit var usernameEdt: EditText

    private lateinit var passwordEdtLayout: TextInputLayout
    private lateinit var passwordEdt: TextInputEditText

    private lateinit var confirmPasswordEdtLayout: TextInputLayout
    private lateinit var confirmPasswordEdt: TextInputEditText

    private lateinit var signUpBtn: Button
    private var passwordText: String = ""
    private var confirmPasswordText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        usernameEdt = findViewById(R.id.username_edt)

        passwordEdtLayout = findViewById(R.id.password_edt_layout)
        passwordEdt = findViewById(R.id.password_edt)

        confirmPasswordEdtLayout = findViewById(R.id.confirm_password_edt_layout)
        confirmPasswordEdt = findViewById(R.id.confirm_password_edt)

        signUpBtn = findViewById(R.id.signUp_btn)

        passwordEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                getPasswordLength()
                confirmPasswordEdtLayout.error = null
            }

            override fun afterTextChanged(p0: Editable?) {
            }


        })
        confirmPasswordEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!validatePassword()) {
                    confirmPasswordEdtLayout.error = "Passwords does not match"
                } else {
                    confirmPasswordEdtLayout.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }


        })

        signUpBtn.setOnClickListener { signUp() }

    }

    private fun signUp() {
        val usernameText = usernameEdt.text.trim().toString()
        if (validatePassword() && usernameText.isNotEmpty() && usernameText.contains("@")) {
            signUpBtn.isEnabled = false
            Toast.makeText(
                this, "Username: $usernameText \n Password: $passwordText",
                Toast.LENGTH_LONG
            ).show()
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        } else {
            if (usernameText.isEmpty()) {
                Toast.makeText(
                    this, "Please enter a valid email id",
                    Toast.LENGTH_LONG
                ).show()
            } else if (!usernameText.contains("@")) {
                Toast.makeText(
                    this, "Please enter a valid email id",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                confirmPasswordEdtLayout.error = "Passwords does not match"
            }

        }
    }

    private fun validatePassword(): Boolean {
        passwordText = passwordEdt.text.toString()
        confirmPasswordText = confirmPasswordEdt.text.toString()

        return passwordText == confirmPasswordText
    }

    fun getPasswordLength() {
        val passwordLength: Int = passwordEdt.length()

        when {
            passwordLength == 0 -> {
                passwordEdtLayout.error = null
                confirmPasswordEdtLayout.error = null
            }
            passwordLength < 8 -> passwordEdtLayout.error = "Password length is too short"
            passwordLength > 14 -> passwordEdtLayout.error = "Password length exceeded"
            else -> passwordEdtLayout.error = null
        }

    }
}