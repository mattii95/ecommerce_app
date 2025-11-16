package com.courrouxdigital.ecommerceapp.domain.usecases.auth

import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository

class LogoutUseCase (private val authRepository: AuthRepository) {
    suspend operator fun invoke() = authRepository.logout()
}