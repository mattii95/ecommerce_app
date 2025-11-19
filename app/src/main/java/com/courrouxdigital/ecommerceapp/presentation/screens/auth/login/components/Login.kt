package com.courrouxdigital.ecommerceapp.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.courrouxdigital.ecommerceapp.domain.utils.Resource
import com.courrouxdigital.ecommerceapp.presentation.components.CustomProgressBar
import com.courrouxdigital.ecommerceapp.presentation.navigation.Graph
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.auth.AuthScreen
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.roles.RolesScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    // TODO!: ADD SPLASH SCREEN

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
                response.data.user?.roles?.size?.let {
                    if (it > 1)
                        navController.navigate(route = Graph.ROLES) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                    else
                        navController.navigate(route = Graph.CLIENT) {
                            popUpTo(Graph.AUTH) { inclusive = true }
                        }
                }
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