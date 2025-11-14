package com.courrouxdigital.ecommerceapp.presentation.screens.auth.register

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.utils.Resource

data class RegisterState(
    val name: String = "test",
    val lastname: String = "test",
    val email: String = "correo@correo.com",
    val phone: String = "54659878",
    val password: String = "123456",
    val confirmPassword: String = "123456",
    val errorMessage: String = "",
    val isValidForm: Boolean = false,
    val response: Resource<AuthResponse>? = null
)
