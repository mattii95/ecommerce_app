package com.courrouxdigital.ecommerceapp.domain.usecases.auth

import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository

class GetSessionUseCase(private val authRepository: AuthRepository) {
    operator fun invoke() = authRepository.getSession()
}