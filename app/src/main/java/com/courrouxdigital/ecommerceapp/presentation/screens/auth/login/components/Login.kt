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
import com.courrouxdigital.ecommerceapp.presentation.navigation.screen.AuthScreen
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()

    when (val response = state.response) {
        Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            viewModel.clearStatus()
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AuthScreen.Home.route)
            }
            viewModel.clearStatus()
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