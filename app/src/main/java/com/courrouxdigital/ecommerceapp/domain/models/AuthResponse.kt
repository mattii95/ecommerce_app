package com.courrouxdigital.ecommerceapp.domain.models

data class AuthResponse(
    val user: User,
    val token: String
)
