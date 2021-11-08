package com.example.imccalculator.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.imccalculator.R
import com.example.imccalculator.utils.authenticateUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val btnLogin = findViewById<Button>(R.id.button_login)
        val tvRedirectToRegisterActivity = findViewById<LinearLayout>(R.id.create_account)

        val editEmail = findViewById<EditText>(R.id.edit_email)
        val editPassword = findViewById<EditText>(R.id.edit_password)

        btnLogin.setOnClickListener {
            val isAuthenticated = authenticateUser(editEmail.text.toString(), editPassword.text.toString(), this)
            if(isAuthenticated) {
                val openLoggedActivity = Intent(this, DashboardActivity::class.java)
                startActivity(openLoggedActivity)
            }
        }

        tvRedirectToRegisterActivity.setOnClickListener {
            val openRegisterActivity = Intent(this, ProfileActivity::class.java)
            startActivity(openRegisterActivity)
        }
    }
}