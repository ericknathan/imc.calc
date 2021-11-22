package com.example.imccalculator.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R
import com.example.imccalculator.utils.convertLocalDateToString
import java.time.LocalDate

class WeightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        supportActionBar!!.hide()

        var tvWeightDate = findViewById<TextView>(R.id.tv_weight_date)
        tvWeightDate.text = convertLocalDateToString(LocalDate.now().toString())

        var etWeight = findViewById<EditText>(R.id.edit_weight)

        var btnSave = findViewById<Button>(R.id.button_save)
        btnSave.setOnClickListener {
            Log.d("xpto", "AAAAAAAAAAAAAAA")
            val data = getSharedPreferences("user", Context.MODE_PRIVATE)

            val editor = data.edit()
            editor.putInt("weight-${LocalDate.now().toString()}", etWeight.text.toString().toInt())
            editor.apply()

            val openDashboardActivity = Intent(this, DashboardActivity::class.java)
            startActivity(openDashboardActivity)

            Toast.makeText(this, "Peso adicionado com sucesso", Toast.LENGTH_LONG).show()
        }
    }
}