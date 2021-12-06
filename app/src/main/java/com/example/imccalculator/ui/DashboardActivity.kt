package com.example.imccalculator.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.imccalculator.R
import com.example.imccalculator.repository.WeighingRepository
import com.example.imccalculator.utils.calculateImc
import com.example.imccalculator.utils.calculateYearsBasedOnDate
import com.example.imccalculator.utils.decodeBase64ToBitmap
import com.example.imccalculator.utils.getUser
import java.time.LocalDate

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
        var btnWeightNow = findViewById<CardView>(R.id.btn_weight_now)
        var btnViewHistoric = findViewById<CardView>(R.id.btn_view_historic)

        val user = getUser(this)
        val userWeight = user.getString("weight", "").toString().split(";").toTypedArray()
        val userHeight = user.getFloat("height", 0F)
        val userImc = calculateImc(userHeight.toDouble(), userWeight.last().toDouble())

        imgProfile.setImageBitmap(decodeBase64ToBitmap(user.getString("profilePicture", "")))
        tvName.text = user.getString("name", "")
        tvProfession.text = user.getString("profession", "")
        tvImc.text = userImc
        tvAge.text = calculateYearsBasedOnDate(user.getString("birthDate", "").toString())
        tvWeight.text = userWeight.last()
        tvHeight.text = userHeight.toString()

        btnWeightNow.setOnClickListener {
            val openWeightActivity = Intent(this, WeightActivity::class.java)
            startActivity(openWeightActivity)
        }

        btnViewHistoric.setOnClickListener {
            val weighingRepository = WeighingRepository(this)
            val weighingList = weighingRepository.getWeighingList()

            for(w in weighingList) {
                Log.i("xpto", "${w.weighingDate} - ${w.weight}")
            }
            val openHistoricActivity = Intent(this, HistoricActivity::class.java)
            startActivity(openHistoricActivity)
        }

    }
}