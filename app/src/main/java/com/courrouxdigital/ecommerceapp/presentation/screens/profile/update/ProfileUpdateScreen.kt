package com.courrouxdigital.ecommerceapp.presentation.screens.profile.update

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.courrouxdigital.ecommerceapp.presentation.components.CustomTopBar
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.update.components.ProfileUpdateContent
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Actualizar Perfil",
                navController = navController,
                upAvailable = true
            )
        },
    ) { paddingValues ->
        ProfileUpdateContent(
            modifier = Modifier.padding(paddingValues),
        )
    }

    UpdateUser()
}