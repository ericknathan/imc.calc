package com.example.imccalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imccalculator.R

class TesteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        supportActionBar!!.hide()
    }
}