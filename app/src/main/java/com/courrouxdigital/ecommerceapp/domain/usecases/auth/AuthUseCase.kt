package com.courrouxdigital.ecommerceapp.domain.usecases.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSession: GetSessionUseCase,
    val logout: LogoutUseCase
)
