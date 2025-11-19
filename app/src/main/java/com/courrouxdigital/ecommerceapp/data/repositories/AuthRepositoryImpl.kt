package com.courrouxdigital.ecommerceapp.data.repositories

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthLocalDatasource
import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthRemoteDatasource
import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.repositories.AuthRepository
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import com.courrouxdigital.ecommerceapp.domain.utils.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDatasource: AuthRemoteDatasource,
    private val authLocalDatasource: AuthLocalDatasource,
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String,
    ): Resource<AuthResponse> {
        val result = authRemoteDatasource.login(email, password)
        return ResponseToRequest.executeAction(result)
    }

    override suspend fun register(user: User): Resource<AuthResponse> {
        val result = authRemoteDatasource.register(user)
        return ResponseToRequest.executeAction(result)
    }

    override suspend fun logout() {
        return authLocalDatasource.logout()
    }

    override suspend fun saveSession(authResponse: AuthResponse) {
        return authLocalDatasource.saveSession(authResponse)
    }

    override suspend fun updateSession(user: User) {
        return authLocalDatasource.updateSession(user)
    }

    override fun getSession(): Flow<AuthResponse> {
        return authLocalDatasource.getSession()
    }
}