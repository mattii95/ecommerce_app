package com.courrouxdigital.ecommerceapp.domain.usecases.auth

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository

class UpdateSessionUseCase (private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: User) = authRepository.updateSession(user)
}