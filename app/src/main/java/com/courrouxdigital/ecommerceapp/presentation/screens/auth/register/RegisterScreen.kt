package com.courrouxdigital.ecommerceapp.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.courrouxdigital.ecommerceapp.presentation.components.CustomTopBar
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.register.components.Register
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.register.components.RegisterContent
import com.courrouxdigital.ecommerceapp.presentation.ui.theme.EcommerceAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )
        }
    ) { innerPadding ->
        RegisterContent(modifier = Modifier.padding(innerPadding))
    }

    Register(navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegisterPreview() {
    EcommerceAppTheme {
        RegisterView(navController = rememberNavController())
    }
}