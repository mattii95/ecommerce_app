package com.courrouxdigital.ecommerceapp.presentation.screens.profile.update

import com.courrouxdigital.ecommerceapp.domain.models.User
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import java.io.File

data class ProfileUpdateState(
    val userData: User? = null,
    val imageUrl: String? = null,
    val file: File? = null,
    val errorMessage: String = "",
    val isValidForm: Boolean = false,
    val response: Resource<User>? = null
)