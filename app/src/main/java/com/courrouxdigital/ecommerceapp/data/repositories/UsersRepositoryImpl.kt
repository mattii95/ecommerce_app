package com.courrouxdigital.ecommerceapp.data.repositories

import com.courrouxdigital.ecommerceapp.data.repositories.datasource.UsersRemoteDatasource
import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.repositories.UsersRepository
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import com.courrouxdigital.ecommerceapp.domain.utils.ResponseToRequest
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDatasource: UsersRemoteDatasource
) : UsersRepository {
    override suspend fun update(user: User): Resource<User> {
        val result = usersRemoteDatasource.register(user)
        return ResponseToRequest.executeAction(result)
    }

    override suspend fun updateWithImage(
        user: User,
        file: File,
    ): Resource<User> {
        val result = usersRemoteDatasource.registerWithImage(user, file)
        return ResponseToRequest.executeAction(result)
    }
}