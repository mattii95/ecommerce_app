package com.courrouxdigital.ecommerceapp.data.repositories.datasource

import com.courrouxdigital.ecommerceapp.domain.models.User
import retrofit2.Response
import java.io.File

interface UsersRemoteDatasource {
    suspend fun register(user: User): Response<User>
    suspend fun registerWithImage(user: User, file: File): Response<User>
}