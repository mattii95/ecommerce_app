package com.courrouxdigital.ecommerceapp.presentation.screens.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen() {
    Scaffold {
        ProfileContent(
            modifier = Modifier.padding(it)
        )
    }
}