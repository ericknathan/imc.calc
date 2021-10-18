package com.example.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val tvRedirectToRegisterActivity = findViewById<LinearLayout>(R.id.create_account)

        tvRedirectToRegisterActivity.setOnClickListener {
            val openRegisterActivity = Intent(this, ProfileActivity::class.java)
            startActivity(openRegisterActivity)
        }
    }
}