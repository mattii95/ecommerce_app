package com.courrouxdigital.ecommerceapp.domain.repositories

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun logout()
    suspend fun saveSession(authResponse: AuthResponse)
    fun getSession(): Flow<AuthResponse>
}