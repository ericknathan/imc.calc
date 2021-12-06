package com.example.imccalculator.repository

import android.content.Context
import com.example.imccalculator.model.Weighing

class WeighingRepository(var context: Context) {
    fun getWeighingList(): List<Weighing> {
        val weighingList = mutableListOf<Weighing>()

        val data = context.getSharedPreferences("user", Context.MODE_PRIVATE)

        val weightsString = data.getString("weight", "")
        val weights = weightsString.toString().split(";").toTypedArray()

        val datesString = data.getString("weightDates", "")
        val dates = datesString.toString().split(";").toTypedArray()

        for(i in weights.indices) {
            val weighing = Weighing(dates[i], weights[i].toInt())
            weighingList.add(weighing)
        }

        return weighingList
    }
}