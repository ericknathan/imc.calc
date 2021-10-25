package com.example.imccalculator.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String): LocalDate {
    val dateFormatterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return LocalDate.parse(brazilDate, dateFormatterFromBrazil)
}