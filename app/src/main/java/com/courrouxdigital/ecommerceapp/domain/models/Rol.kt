package com.courrouxdigital.ecommerceapp.domain.models

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Rol(
    val id: String,
    val name: String,
    val image_url: String,
    val route: String,
) {
    fun toJson(): String = Gson().toJson(
        Rol(
            id,
            name,
            image_url = if (!image_url.isNullOrBlank()) URLEncoder.encode(
                image_url,
                StandardCharsets.UTF_8.toString()
            ) else "",
            route
        )
    )

    companion object {
        fun fromJson(data: String): Rol = Gson().fromJson(data, Rol::class.java)
    }
}
