package com.courrouxdigital.ecommerceapp.presentation.screens.auth.register

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.utils.Resource

data class RegisterState(
    val name: String = "",
    val lastname: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val errorMessage: String = "",
    val isValidForm: Boolean = false,
    val response: Resource<AuthResponse>? = null
)
