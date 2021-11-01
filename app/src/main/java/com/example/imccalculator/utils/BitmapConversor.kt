package com.example.imccalculator.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.util.*

fun encodeBitmapToBase64(imageBitmap: Bitmap?): String {
    val stream = ByteArrayOutputStream()
    imageBitmap?.compress(Bitmap.CompressFormat.PNG, 90, stream)

    return Base64.getEncoder().encodeToString(stream.toByteArray())
}

fun decodeBase64ToBitmap(encodedBase64: String?): Bitmap? {
    val decodedBase64 = Base64.getDecoder().decode(encodedBase64)

    return BitmapFactory.decodeByteArray(decodedBase64, 0, decodedBase64.size)
}