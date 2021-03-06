package com.example.imccalculator.model

import java.time.LocalDate

data class User(
    var id: Int,
    var name: String,
    var email: String,
    var password: String,
    var weight: String,
    var height: Double,
    var birthDate: LocalDate,
    var profession: String,
    var gender: Char,
    var profilePicture: String
)