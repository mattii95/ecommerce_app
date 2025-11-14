package com.courrouxdigital.ecommerceapp.data.repositories.datasource

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.models.User
import retrofit2.Response

interface AuthRemoteDatasource {
    suspend fun login(email: String, password: String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>
}