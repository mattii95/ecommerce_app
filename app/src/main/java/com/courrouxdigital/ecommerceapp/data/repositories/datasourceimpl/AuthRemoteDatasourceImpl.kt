package com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.data.service.AuthService
import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import retrofit2.Response

class AuthRemoteDatasourceImpl(
    private val authService: AuthService,
) : AuthRemoteDatasource {
    override suspend fun login(email: String, password: String): Response<AuthResponse> =
        authService.login(email, password)
}