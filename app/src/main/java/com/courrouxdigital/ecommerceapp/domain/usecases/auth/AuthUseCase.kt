package com.courrouxdigital.ecommerceapp.domain.usecases.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val updateSession: UpdateSessionUseCase,
    val getSession: GetSessionUseCase,
    val logout: LogoutUseCase
)
