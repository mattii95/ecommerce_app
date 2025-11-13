package com.courrouxdigital.ecommerceapp.presentation.screens.auth.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.login.components.LoginContent

@Composable
fun LoginView(navController: NavHostController) {
    Scaffold() { innerPadding ->
        LoginContent(
            modifier = Modifier.padding(innerPadding),
            navController = navController
        )
    }
}