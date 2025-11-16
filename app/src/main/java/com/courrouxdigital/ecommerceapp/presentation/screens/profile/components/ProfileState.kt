package com.courrouxdigital.ecommerceapp.presentation.screens.profile.components

import com.courrouxdigital.ecommerceapp.domain.models.AuthResponse

data class ProfileState(
    val session: AuthResponse? = null
)
