package com.example.imccalculator.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast

fun authenticateUser(email: String, password: String, context: Context): Boolean {
    var isAuthenticated = false;
    val data = context.getSharedPreferences("user", Context.MODE_PRIVATE)
    var storedEmail = data.getString("email", "")
    var storedPassword = data.getString("password", "")

    if(email == "" || password == "") {
        Toast.makeText(context, "É necessário preencher corretamente todos os campos.", Toast.LENGTH_LONG).show()
    } else if(email != storedEmail.toString() || password != storedPassword.toString()) {
        Toast.makeText(context, "Usuário ou senha incorretos.", Toast.LENGTH_LONG).show()
    } else {
        isAuthenticated = true
    }
    return isAuthenticated;
}

fun getUser(context: Context): SharedPreferences {
    val data = context.getSharedPreferences("user", Context.MODE_PRIVATE)
    return data
}