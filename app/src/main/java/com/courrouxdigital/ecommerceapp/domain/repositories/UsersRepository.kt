package com.courrouxdigital.ecommerceapp.domain.repositories

import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import java.io.File

interface UsersRepository {
    suspend fun update(user: User): Resource<User>
    suspend fun updateWithImage(user: User, file: File): Resource<User>
}