package com.courrouxdigital.ecommerceapp.domain.usecases.users

import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.repositories.UsersRepository
import com.courrouxdigital.ecommerceapp.domain.utils.Resource

class UpdateUserUseCase(
    private val usersRepository: UsersRepository
) {

    suspend operator fun invoke(user: User): Resource<User> {
        return usersRepository.update(user)
    }

}