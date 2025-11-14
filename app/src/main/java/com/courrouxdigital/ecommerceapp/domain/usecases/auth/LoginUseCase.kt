package com.courrouxdigital.ecommerceapp.domain.usecases.auth

import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        authRepository.login(email, password)
}