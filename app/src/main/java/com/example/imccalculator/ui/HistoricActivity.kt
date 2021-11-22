package com.example.imccalculator.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import com.example.imccalculator.R

class HistoricActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)

        val sv_weight_list = findViewById<ScrollView>(R.id.sv_weight_list)

        val data = getSharedPreferences("user", Context.MODE_PRIVATE)
        data.all.forEach {
            Log.d("xpto", it.toString())
        }
    }
}