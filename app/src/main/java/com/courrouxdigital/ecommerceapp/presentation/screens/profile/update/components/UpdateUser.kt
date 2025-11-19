package com.courrouxdigital.ecommerceapp.presentation.screens.profile.update.components

import android.util.Log
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
import com.courrouxdigital.ecommerceapp.presentation.navigation.Graph
import com.courrouxdigital.ecommerceapp.presentation.screens.auth.login.LoginViewModel
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser(
    viewModel: ProfileUpdateViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()

    when (val response = state.response) {
        Resource.Loading -> {
            CustomProgressBar()
            viewModel.clearStatus()
        }

        is Resource.Success -> {
            viewModel.clearStatus()
            viewModel.updateUserSession(response.data)
            Toast.makeText(
                LocalContext.current,
                "Los datos se han actualizado correctamete",
                Toast.LENGTH_SHORT
            ).show()
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