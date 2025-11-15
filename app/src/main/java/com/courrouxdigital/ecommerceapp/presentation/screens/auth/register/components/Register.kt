package com.courrouxdigital.ecommerceapp.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import com.courrouxdigital.ecommerceapp.presentation.components.CustomProgressBar
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(
    navController: NavHostController,
    viewModel: RegisterViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    when (val response = state.response) {
        Resource.Loading -> {
            CustomProgressBar()
            viewModel.clearStatus()
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                viewModel.saveSession(response.data)
                viewModel.clearStatus()
//                navController.navigate(route = AuthScreen.Home.route){
//                    popUpTo(AuthScreen.Login.route) { inclusive = true }
//                }
            }
        }

        is Resource.Error -> {
            Toast.makeText(
                LocalContext.current,
                response.message,
                Toast.LENGTH_SHORT
            ).show()
            viewModel.clearStatus()
        }

        else -> {
            if (response != null) {
                Toast.makeText(
                    LocalContext.current,
                    "Error desconocido",
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.clearStatus()
            }
        }
    }
}