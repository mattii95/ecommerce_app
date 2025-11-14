package com.courrouxdigital.ecommerceapp.data.repositories.datasource

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDatasource {
    suspend fun saveSession(authResponse: AuthResponse)
    fun getSession(): Flow<AuthResponse>
}