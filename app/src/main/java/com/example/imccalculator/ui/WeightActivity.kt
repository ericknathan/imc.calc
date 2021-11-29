package com.example.imccalculator.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalculator.R
import com.example.imccalculator.utils.convertLocalDateToString
import java.time.LocalDate

class WeightActivity : AppCompatActivity() {

    lateinit var tvWeightDate: TextView;
    lateinit var etNewWeight: EditText;
    lateinit var spinnerLevel: Spinner;
    lateinit var btnSave: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        supportActionBar!!.hide()

        btnSave = findViewById<Button>(R.id.button_save)
        etNewWeight = findViewById<EditText>(R.id.edit_weight)
        tvWeightDate = findViewById<TextView>(R.id.tv_weight_date)
        spinnerLevel = findViewById(R.id.spinner_levels)
        tvWeightDate.text = convertLocalDateToString(LocalDate.now().toString())

        btnSave.setOnClickListener {
            val data = getSharedPreferences("user", Context.MODE_PRIVATE)

            val editor = data.edit()
            editor.putString("weight", "${data.getString("weight", "").toString()};${etNewWeight.text.toString().toInt()}")
            editor.putString("weight-dates", "${data.getString("weight-dates", "").toString()};${LocalDate.now().toString()}")
            editor.putString("weight-levels", "${data.getString("weight-levels", "").toString()};${spinnerLevel.selectedItemPosition}")
            editor.apply()

            val openDashboardActivity = Intent(this, DashboardActivity::class.java)
            startActivity(openDashboardActivity)

            Toast.makeText(this, "Peso adicionado com sucesso", Toast.LENGTH_LONG).show()
        }
    }
}