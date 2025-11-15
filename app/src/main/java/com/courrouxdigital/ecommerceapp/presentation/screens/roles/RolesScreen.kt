package com.courrouxdigital.ecommerceapp.presentation.screens.roles

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.courrouxdigital.ecommerceapp.presentation.components.CustomTopBar
import com.courrouxdigital.ecommerceapp.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopBar("Selecciona un Rol")
        }
    ) {
        RolesContent(
            modifier = Modifier.padding(it),
            navController = navController
        )
    }
}