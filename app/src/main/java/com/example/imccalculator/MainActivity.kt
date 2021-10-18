package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()


        val height = findViewById<EditText>(R.id.edit_text_height)
        val weight = findViewById<EditText>(R.id.edit_text_weight)

        val button = findViewById<Button>(R.id.calculate_button)
        val result = findViewById<TextView>(R.id.result_text)
        val status = findViewById<TextView>(R.id.status_text)

        button.setOnClickListener {
            if(height.text.toString().trim().length  <= 1 || weight.text.toString().trim().length  <= 1 ) {
                Toast.makeText(this, "Você não preencheu todos os campos corretamente!", Toast.LENGTH_LONG).show()
            } else {
                val imc = calculateImc(height.text.toString().toDouble(), weight.text.toString().toDouble())
                result.text = imc
                status.text = getStatus(imc.toDouble())
            }
        }
    }
}
