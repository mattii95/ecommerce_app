package com.courrouxdigital.ecommerceapp.domain.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    @SerializedName("id") val id: Number? = null,
    @SerializedName("name") var name: String,
    @SerializedName("lastname") var lastname: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") var phone: String,
    @SerializedName("password") val password: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("notification_token") val notificationToken: String? = null,
    @SerializedName("roles") val roles: List<Rol>? = null,
) : Serializable {
    fun toJson(): String = Gson().toJson(
        User(
            id, name, lastname, email, phone, password,
            imageUrl = if (!imageUrl.isNullOrBlank()) URLEncoder.encode(
                imageUrl,
                StandardCharsets.UTF_8.toString()
            ) else "",
            notificationToken,
            roles = roles?.map { rol -> Rol.fromJson(rol.toJson()) }
        ))

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}
