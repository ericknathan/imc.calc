package com.example.imccalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.imccalculator.R
import com.example.imccalculator.utils.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.hide()

        var tvName = findViewById<TextView>(R.id.tv_name)
        var tvProfession = findViewById<TextView>(R.id.tv_profession)
        var tvImc = findViewById<TextView>(R.id.tv_imc)
        var tvNcd = findViewById<TextView>(R.id.tv_ncd)
        var tvAge = findViewById<TextView>(R.id.tv_age)
        var tvWeight = findViewById<TextView>(R.id.tv_weight)
        var tvHeight = findViewById<TextView>(R.id.tv_height)
        var imgProfile = findViewById<ImageView>(R.id.img_profile)

        val user = getUser(this)
        val userWeight = user.getInt("weight", 0)
        val userHeight = user.getFloat("height", 0F)
        val userImc = calculateImc(userHeight.toDouble(), userWeight.toDouble())

        Log.d("xpto", userImc)

        imgProfile.setImageBitmap(decodeBase64ToBitmap(user.getString("profilePicture", "")))
        tvName.text = user.getString("name", "")
        tvProfession.text = user.getString("profession", "")
        tvImc.text = userImc
        tvAge.text = calculateYearsBasedOnDate(convertStringToLocalDate(convertLocalDateToString(user.getString("birthDate", "").toString()))).toString()
        tvWeight.text = userWeight.toString()
        tvHeight.text = userHeight.toString()
    }
}