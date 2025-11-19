package com.courrouxdigital.ecommerceapp.data.repositories.datasourceimpl

import com.courrouxdigital.ecommerceapp.data.datastore.AuthDataStore
import com.courrouxdigital.ecommerceapp.data.repositories.datasource.AuthLocalDatasource
import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse
import com.courrouxdigital.ecommerceapp.domain.models.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDatasourceImpl(private val authDataStore: AuthDataStore): AuthLocalDatasource {
    override suspend fun saveSession(authResponse: AuthResponse) {
        return authDataStore.save(authResponse)
    }

    override suspend fun updateSession(user: User) {
        return authDataStore.update(user)
    }

    override suspend fun logout() {
        return authDataStore.delete()
    }

    override fun getSession(): Flow<AuthResponse> {
        return authDataStore.getData()
    }
}