package com.example.imccalculator

fun calculateImc(height: Double, weight: Double): String {
    val imc = (weight / (height * height))
    return String.format("%.1f", imc)
}

fun getStatus(imc: Double): String {
    return when {
        imc < 18.5 -> "Abaixo do peso"
        imc < 24.9 -> "Peso ideal"
        imc < 24.9 -> "Acima do peso"
        imc < 29.9 -> " Obesidade de grau I"
        imc < 34.9 -> "Obesidade de grau II"
        else -> "Obesidade de grau III"
    }
}