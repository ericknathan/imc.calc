package com.example.imccalculator.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String?): LocalDate {
    val dateFormatterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return LocalDate.parse(brazilDate, dateFormatterFromBrazil)
}

fun convertLocalDateToString(date: String?): String {
    return if(date !== null) {
        val dateFormatterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        LocalDate.parse(date).format(dateFormatterFromBrazil).toString()
    } else ""
}

fun calculateYearsBasedOnDate(date: String): String {
    val convertedDate = LocalDate.parse(date)
    return Period.between(
        convertedDate,
        LocalDate.now()
    ).years.toString()
}