package com.courrouxdigital.ecommerceapp.presentation.screens.auth.login

import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse

data class LoginState(
    val email: String = "",
    val password: String = "",
    val errorMessage: String = "",
    val isValidForm: Boolean = false,
    val response: Resource<AuthResponse>? = null
)
