package com.courrouxdigital.ecommerceapp.presentation.screens.auth.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val errorMessage: String = "",
    val isValidForm: Boolean = false
)
