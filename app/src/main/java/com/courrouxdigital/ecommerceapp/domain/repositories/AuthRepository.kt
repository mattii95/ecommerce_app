package com.courrouxdigital.ecommerceapp.domain.repositories

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.utils.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
}