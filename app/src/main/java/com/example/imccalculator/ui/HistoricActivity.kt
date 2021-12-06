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

        supportActionBar!!.hide()
        // val sv_weight_list = findViewById<ScrollView>(R.id.sv_weight_list)

        val data = getSharedPreferences("user", Context.MODE_PRIVATE)
        val weights = data.getString("weight", "")
        val weightDates = data.getString("weightDates", "").toString().split(";")
        val arrayWeights = weights.toString().split(";")

        println("xpto $weightDates")

        if(weightDates !== null || arrayWeights.isNotEmpty()) {
            for((index, value) in arrayWeights.withIndex()) {
                println("xpto Data: ${weightDates?.get(index)} Peso: $value")
            }
        }
    }
}