package com.courrouxdigital.ecommerceapp.domain.usecases.auth

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository

class SaveSessionUseCase (private val authRepository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = authRepository.saveSession(authResponse)
}