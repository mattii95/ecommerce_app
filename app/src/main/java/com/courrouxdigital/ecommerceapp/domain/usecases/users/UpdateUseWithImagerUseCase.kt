package com.courrouxdigital.ecommerceapp.domain.usecases.users

import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.repositories.UsersRepository
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import java.io.File

class UpdateUseWithImagerUseCase(
    private val usersRepository: UsersRepository,
) {

    suspend operator fun invoke(user: User, file: File): Resource<User> {
        return usersRepository.updateWithImage(user, file)
    }

}